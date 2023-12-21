package com.example.springBoot.config;


import com.example.springBoot.config.JWTRequestFilter;
import com.example.springBoot.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService myUserDetails;
    @Autowired
    JWTRequestFilter jwtRequestFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetails);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/**").permitAll() //for swagger
                .antMatchers("/login/").permitAll()
                .antMatchers("/roles/**").permitAll()
                .antMatchers("/authorities/**").permitAll()
                .antMatchers("/users/**").permitAll()
                .antMatchers("/swagger**").permitAll()
                .anyRequest().authenticated()
//                .anyRequest().permitAll()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
    //The following bean declaration is necessary to work with AuthenticationManager in Home Controller
//  It was not needed before - that is in SpringBoot 1.0
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    //We can use BCrypt here for password encoding
    @Bean
    public PasswordEncoder passwordEncode(){
        return  NoOpPasswordEncoder.getInstance();
//        return new BCryptPasswordEncoder();
    }
}


