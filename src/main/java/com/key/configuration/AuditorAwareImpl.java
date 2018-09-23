package com.key.configuration;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuditorAwareImpl implements AuditorAware<String> {

	
	@Override
	public Optional<String> getCurrentAuditor() {
		
//		User user  = ((UserAwareUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getPrincipal().toString());
		
		String userEmail = authentication.getName();
        
        return Optional.of(userEmail);
	}
    
}
