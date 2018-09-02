package com.key.configuration;

import com.key.model.AclConfig;
import com.key.security.CustomBasicAuthenticationEntryPoint;
import com.key.service.SecurityServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.
			jdbcAuthentication()
				.usersByUsernameQuery(usersQuery)
				.authoritiesByUsernameQuery(rolesQuery)
				.dataSource(dataSource)
				.passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		List<AclConfig> configs =securityServices.findAll();
		System.out.println("configs = "+configs);
		

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
			System.out.println("configs = "+configs.get(i).getPath()+" values "+configs.get(i).getValues());
			http.authorizeRequests().antMatchers(configs.get(i).getPath()).hasAnyAuthority(configs.get(i).getValues());
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
}