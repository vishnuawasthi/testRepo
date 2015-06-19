/**
 * 
 */
package com.ziffi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author vawasthi
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		/*
		 * auth.inMemoryAuthentication().withUser("user").password("password")
		 * .roles("USER");
		 */
		/*auth.jdbcAuthentication()
				.dataSource(getDataSource())
				.usersByUsernameQuery(
						"select username,password from users where username=?")
				.authoritiesByUsernameQuery(
						"select u.username, r.authority from users u, roles r where u.userid = r.userid and u.username =?");*/
	/*	
		auth
    .jdbcAuthentication()
      .dataSource( getDataSource());*/
	}

	
}
