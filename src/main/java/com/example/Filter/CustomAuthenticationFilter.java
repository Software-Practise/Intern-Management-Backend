package com.example.Filter;

import com.example.Filter.UsernameAndPasswordAuthenticationRequest;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    protected final Log log = LogFactory.getLog(getClass());

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    // @Override
    // public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
    //         throws AuthenticationException {
    //     String nwId = request.getParameter("nwId");
    //     String password = request.getParameter("password");
    //     log.info("NWID is :" + nwId);
    //     log.info("Password is : " + password);
    //     UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(nwId, password);
    //     return authenticationManager.authenticate(authenticationToken);

    // }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        // String nwId = request.getParameter("nwId");
        // String password = request.getParameter("password");
        // log.info("NWID is :" + nwId);
        // log.info("Password is : " + password);
        // UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(nwId, password);
        // return authenticationManager.authenticate(authenticationToken);

        try {
            UsernameAndPasswordAuthenticationRequest authenticationRequest = new ObjectMapper()
                    .readValue(request.getInputStream(), UsernameAndPasswordAuthenticationRequest.class);

                    Authentication authentication = new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getNwId(),
                        authenticationRequest.getPassword()
                );
    
                log.info("NWID is :" + authenticationRequest.getNwId());
                log.info("Password is : " + authenticationRequest.getPassword());
                Authentication authenticate = authenticationManager.authenticate(authentication);
                return authenticate;
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authentication) throws IOException, ServletException {
        
        User user = (User) authentication.getPrincipal();
        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
        String access_token = JWT.create()
                            .withSubject(user.getUsername())
                            .withExpiresAt(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                            .withIssuer(request.getRequestURL().toString())
                            .withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                            .sign(algorithm);

        String refresh_token = JWT.create()
                            .withSubject(user.getUsername())
                            .withExpiresAt(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                            .withIssuer(request.getRequestURL().toString())
                            .sign(algorithm);
        /*response.setHeader("access_token", access_token);
        response.setHeader("refresh_token", refresh_token);*/

        Map<String, String> tokens = new HashMap<>();
        tokens.put("access_token", access_token);
        tokens.put("refresh_token", refresh_token);
        response.setContentType("application/json");
        new ObjectMapper().writeValue(response.getOutputStream(), tokens);

    }

    
    
}
