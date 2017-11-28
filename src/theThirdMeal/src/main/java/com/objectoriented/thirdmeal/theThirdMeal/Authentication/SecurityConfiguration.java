package com.objectoriented.thirdmeal.theThirdMeal.Authentication;

import com.objectoriented.thirdmeal.theThirdMeal.Entities.UserRolesEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("userDetailsService")
	UserService userService;

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
			.antMatchers("/signup", "/hello", "/error")
				.permitAll()
			.antMatchers("/", "/index")
				.authenticated()
			.antMatchers( "/customerHome", "/restaurantView")
				.hasAuthority(UserRolesEnum.CUSTOMER.name())
			.antMatchers("/restaurantOwnerHome", "/restaurantCreateEdit")
				.hasAuthority(UserRolesEnum.RESTAURANT_OWNER.name())
			.and()
			.formLogin()
				.loginPage("/login").permitAll()
			.and()
			.logout()
				.logoutSuccessUrl("/");
	}

	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
