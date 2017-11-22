package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Users")
public class User extends UniqueItem
{

	@Column(name = "Username", nullable = false, unique = true)
	protected String _username;

	@Column(name = "Password", nullable = false)
	protected String _password;

	@OneToMany(mappedBy = "_user", cascade = CascadeType.ALL)
	protected List<UserRole> _userRoles;

	public User(){}

	public User(String username, String password, List<UserRole> userRoles)
	{
		_username = username;
		_password = password;
		_userRoles = userRoles;
	}

	public String getUsername() { return _username; }
	public void setUsername(String username) { _username = username; }

	public String getPassword() { return _password; }
	public void setPassword(String password) { _password = password; }

	public List<UserRole> getUserRoles() { return _userRoles; }
	public void setUserRoles(List<UserRole> userRoles) { _userRoles = userRoles; }

	public void loadProperties()
	{
		if(_userRoles != null)
			_userRoles.size();
	}
}
