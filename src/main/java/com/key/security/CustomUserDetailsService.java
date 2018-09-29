package com.key.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.key.model.User;
import com.key.service.UserService;

/**
 * Custom User Details Service.  Create Custom User Details implementation.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    
	

	private final UserService userService;

    public CustomUserDetailsService(final UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        final User user = userService.findUserByEmail(email);
        System.out.println("loadUserByUsername..."+user.getEmail());
        if (user == null) {
            throw new UsernameNotFoundException("User not found.");
        }
        return new CustomUserDetails(user,userService);
    }
}
