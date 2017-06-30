package com.in28minutes.pringbot.web.springbootfirstwebapplication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private DataSource dataSource;

	@Value("${spring.queries.business-query}")
	private String businessQuery;

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
					.authorizeRequests()
					.antMatchers("/").permitAll()
					.antMatchers("/login").permitAll()
					.antMatchers("/registration").permitAll()
					.antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
					.authenticated().and().csrf().disable().
					formLogin()
					.loginPage("/login")
					.failureUrl("/login?error=true")
					.defaultSuccessUrl("/admin/home")
					.usernameParameter("email")
					.passwordParameter("password")
					.and().
					logout()
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.logoutSuccessUrl("/").and().exceptionHandling()
					.accessDeniedPage("/access-denied");
		}


	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.jdbcAuthentication()
				.usersByUsernameQuery(businessQuery)
				.dataSource(dataSource)
				.passwordEncoder(bCryptPasswordEncoder);
	}
}
