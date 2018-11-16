package com.key.configuration;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.key.security.CustomUserDetails;

public class AuditorAwareImpl implements AuditorAware<Integer> {

	
	@Override
	public Optional<Integer> getCurrentAuditor() {
		
//		User user  = ((UserAwareUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CustomUserDetails userdetails=(CustomUserDetails) authentication.getPrincipal();
//        System.out.println(userdetails.getUserId()+"  getCurrentAuditor "+authentication.getPrincipal().toString() 
//        		+" authorities ="+authentication.getAuthorities());
		
		Long userId = userdetails.getUserId();
        
        return Optional.of(userId.intValue());
	}
    
}
