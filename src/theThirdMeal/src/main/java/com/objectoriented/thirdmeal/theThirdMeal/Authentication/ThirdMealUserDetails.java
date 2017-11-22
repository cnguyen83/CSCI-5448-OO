package com.objectoriented.thirdmeal.theThirdMeal.Authentication;

import com.objectoriented.thirdmeal.theThirdMeal.Entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class ThirdMealUserDetails extends User implements UserDetails
{
	public ThirdMealUserDetails(String username, String password, Long userKey, Collection<? extends GrantedAuthority> grantedAuthorities)
	{
		super.setUsername(username);
		super.setPassword(password);
		super.setKey(userKey);
		_grantedAuthorities = grantedAuthorities;
	}

	private Collection<? extends GrantedAuthority> _grantedAuthorities;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return _grantedAuthorities;
	}

	@Override
	public String getPassword()
	{
		return _password;
	}

	@Override
	public String getUsername()
	{
		return _username;
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
