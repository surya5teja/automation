package com.automation.main;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.automation.model.GlobalConstants;

@Configuration
@EnableWebSecurity
public class TdpWebSecurityConfigureAdapter extends WebSecurityConfigurerAdapter {

	@Resource
	private Environment env;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser(env.getProperty(GlobalConstants.BASIC_AUTH_USER))
				.password(env.getProperty(GlobalConstants.BASIC_AUTH))
				.roles(env.getProperty(GlobalConstants.BASIC_AUTH_ROLE));

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().fullyAuthenticated();
		http.httpBasic();
		http.csrf().disable();
	}

}
