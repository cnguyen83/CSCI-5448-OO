package com.objectoriented.thirdmeal.theThirdMeal.Authentication;

import com.objectoriented.thirdmeal.theThirdMeal.Entities.User;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class ThirdMealUserDetails extends User implements UserDetails
{
	private Collection<? extends GrantedAuthority> grantedAuthorities;

	public ThirdMealUserDetails(String username, String password, Long userKey,
	                            List<UserRole> userRoles, Collection<? extends GrantedAuthority> grantedAuthorities)
	{
		this.key = userKey;
		this.username = username;
		this.password = password;
		this.userRoles = userRoles;
		this.grantedAuthorities = grantedAuthorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.grantedAuthorities;
	}

	@Override
	public String getPassword()
	{
		return this.password;
	}

	@Override
	public String getUsername()
	{
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired()
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
