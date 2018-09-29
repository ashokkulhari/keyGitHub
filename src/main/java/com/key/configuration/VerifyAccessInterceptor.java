package com.key.configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.key.service.UserService;

@Component
public class VerifyAccessInterceptor implements HandlerInterceptor {

	@Autowired
	private UserService userService;
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       System.out.println("...preHandle...");
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<GrantedAuthority> updatedAuthorities = new ArrayList<>();
        for (int i = 0; i < updatedAuthorities.size(); i++) {
        	GrantedAuthority g =updatedAuthorities.get(i);
        	System.out.println("OlD authority ="+g.getAuthority());
        }
        List<String> authories =userService.getAuthoritiesByEmail(auth.getName());
        if (authories != null) {
        	for (int i = 0; i < authories.size(); i++) {
        		System.out.println("adding authority  : "+authories.get(i));
        		updatedAuthorities.add(new SimpleGrantedAuthority(authories.get(i))); 
			}
        }
        Authentication newAuth = new UsernamePasswordAuthenticationToken(auth.getPrincipal(), auth.getCredentials(), updatedAuthorities);
		SecurityContextHolder.getContext().setAuthentication(newAuth);
		System.out.println("interceptot "+SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
    		throws Exception {
    	request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, null);
    	HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
