package com.key.configuration;

import com.key.model.AclConfig;
import com.key.security.CustomBasicAuthenticationEntryPoint;
import com.key.security.CustomUserDetailsService;
import com.key.service.SecurityServices;
import com.key.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static final String REALM="KEY_SERVER_REALM";

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private DriverManagerDataSource dataSource;
	
	@Value("${spring.queries.users-query}")
	private String usersQuery;
	
	@Value("${spring.queries.roles-query}")
	private String rolesQuery;

	@Autowired
	SecurityServices securityServices;
	
	@Autowired
	private  UserService userService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth
        .userDetailsService(new CustomUserDetailsService(userService))
		.passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		List<AclConfig> configs =securityServices.findAll();
//		System.out.println("configs = "+configs);
		

		http.csrf().disable()
				.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/login/").permitAll()
				.antMatchers("/register/").permitAll()
				//.antMatchers("/mail/").permitAll()
				.antMatchers("/resetpass/").permitAll()
				.antMatchers("/activateuser/").permitAll()
//				.antMatchers("/changepass/").hasAuthority("ROLE_USER")
//				.antMatchers("/deleteuser/").hasAuthority("ROLE_ADMIN")
//				.antMatchers("/account/**").hasAuthority("ROLE_ADMIN")
				.and().httpBasic().realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint());
		for (int i = 0; i < configs.size(); i++) {
//			System.out.println("configs = "+configs.get(i).getPath()+" values "+configs.get(i).getAuthority().getAuthorityName());
			http.authorizeRequests().antMatchers(configs.get(i).getPath()).hasAnyAuthority(configs.get(i).getAuthority().getAuthorityName());
		}
		
	}

	@Bean
	public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint(){
		return new CustomBasicAuthenticationEntryPoint();
	}

//	@Override
//	public void configure(WebSecurity web) throws Exception {
//	    web
//	       .ignoring()
//	       .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
//	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	}
	
	@Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }
	 @Bean
	    public FilterRegistrationBean corsFilter() {
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        CorsConfiguration config = new CorsConfiguration();
	        config.setAllowCredentials(true);
	        config.addAllowedOrigin("*");
	        config.addAllowedHeader("*");
	        config.addAllowedMethod("*");
	        source.registerCorsConfiguration("/**", config);
	        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
	        bean.setOrder(0);
	        return bean;
	    }
	
	 
	 
}