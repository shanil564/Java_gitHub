package com.example.demo.config;


import com.example.demo.Constants;
import com.example.demo.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTRequestFilter extends OncePerRequestFilter {
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    JwtUtil jwtUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        final String authorizationHeader = httpServletRequest.getHeader("Authorization");
        String username=null;
        String jwt=null;
        if (authorizationHeader!=null && authorizationHeader.startsWith(Constants.JWT_TOKEN_PREFIX_FOR_AUTHENTICATION)){
            jwt = authorizationHeader.substring(7);
            username = jwtUtil.extractUserName(jwt);
        }
        if (username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

            if(jwtUtil.validateToken(jwt,userDetails)){
                System.out.println("Token validated");
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }else {
                System.out.println("Could not validate token");
            }
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
