package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Users")
public class User extends UniqueItem
{

	@Column(name = "Username")
	private String _username;

	@Column(name = "Password")
	private String _password;

	@OneToMany(mappedBy = "_user", cascade = CascadeType.ALL)
	private List<UserRole> _userRoles;

	public String getUsername() { return _username; }
	public void setUsername(String username) { _username = username; }

	public String getPassword() { return _password; }
	public void setPassword(String password) { _password = password; }

	public List<UserRole> getUserRoles() { return _userRoles; }
	public void setUserRoles(List<UserRole> userRoles) { _userRoles = userRoles; }
}
