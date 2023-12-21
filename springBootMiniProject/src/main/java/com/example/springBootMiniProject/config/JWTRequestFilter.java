package com.example.springBootMiniProject.config;
import com.example.springBootMiniProject.Constants;
import com.example.springBootMiniProject.service.implementation.UserDetailsService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Component
public class JWTRequestFilter extends OncePerRequestFilter {
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    JwtUtil jwtUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        final String authorizationHeader = httpServletRequest.getHeader(Constants.JWT_HEADER_FOR_AUTHENTICATION);
        String username=null;
        String jwt=null;
        if (authorizationHeader!=null && authorizationHeader.startsWith(Constants.JWT_TOKEN_PREFIX_FOR_AUTHENTICATION)){
            jwt = authorizationHeader.substring(Constants.SEVEN);
            username = jwtUtil.extractUserName(jwt);
        }
        if (username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            if(jwtUtil.validateToken(jwt,userDetails)){
                logger.info("Token validated");
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }else {
                logger.info("Could not validate token");
            }
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
