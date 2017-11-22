package com.objectoriented.thirdmeal.theThirdMeal.Authentication;

import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.ISearchRepository;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.User;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
public class UserService implements UserDetailsService
{
	@Autowired
	private ISearchRepository<User> userSearchRepository;

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException
	{
		List<User> users = userSearchRepository.search(s);

		if(users == null || users.isEmpty())
			throw new UsernameNotFoundException("");

		User user = users.get(0);

		try
		{
			return convertUserToUserDetails(user);
		}
		catch(Exception ex)
		{
			throw new UsernameNotFoundException(ex.getMessage());
		}
	}

	public static User getCurrentUser()
	{
		return (ThirdMealUserDetails)SecurityContextHolder.getContext()
			.getAuthentication().getPrincipal();
	}

	private ThirdMealUserDetails convertUserToUserDetails(User user) throws Exception
	{
		if(user == null)
			throw new Exception("The user to convert was null.");

		List<UserRole> userRoles = user.getUserRoles();

		if(userRoles == null)
			throw new Exception("The user did not have any roles.");

		return new ThirdMealUserDetails(user.getUsername(), user.getPassword(),
			user.getKey(), convertUserRolesToGrantedAuthority(userRoles));
	}

	private List<GrantedAuthority> convertUserRolesToGrantedAuthority(List<UserRole> userRoles)
	{
		ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

		for(UserRole userRole : userRoles)
		{
			grantedAuthorities.add(new SimpleGrantedAuthority(userRole.getRole().name()));
		}

		return grantedAuthorities;
	}
}
