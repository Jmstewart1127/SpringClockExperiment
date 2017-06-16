package com.in28minutes.pringbot.web.springbootfirstwebapplication.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.in28minutes.springboot.web.springbootfirstwebapplication.service.BusinessService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private BusinessService businessService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/resources/**", "/registration").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll();
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.businessService(businessService).passwordEncoder(bCryptPasswordEncoder());
//    }
//	
	
	
	
	
//	// Create Users - jake, password: 'password'
//	@Autowired
//	public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
//			throws Exception {
//		auth.inMemoryAuthentication().withUser("in28Minutes").password("dummy")
//				.roles("USER", "ADMIN");
//	}
//	
//	@Autowired
//	DataSource dataSource;
// 
//	@Autowired
//	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//		auth.jdbcAuthentication().dataSource(dataSource)
//				.usersByUsernameQuery("select bizName, password, enabled from Business where bizName=?");
//	}
// 
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/", "/home").permitAll().antMatchers("/admin").hasRole("ADMIN")
//				.anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().logout()
//				.permitAll();
//		http.exceptionHandling().accessDeniedPage("/403");
//	}

	
}
