package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Users")
public class User extends UniqueItem
{
	@Column(name = "Username", nullable = false, unique = true)
	protected String username;

	@Column(name = "Password", nullable = false)
	protected String password;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	protected List<UserRole> userRoles;

	public User(){}

	public User(String username, String password, List<UserRole> userRoles)
	{
		this.username = username;
		this.password = password;
		this.userRoles = userRoles;
	}

	public String getUsername() { return this.username; }
	public void setUsername(String username) { this.username = username; }

	public String getPassword() { return this.password; }
	public void setPassword(String password) { this.password = password; }

	public List<UserRole> getUserRoles() { return this.userRoles; }
	public void setUserRoles(List<UserRole> userRoles) { this.userRoles = userRoles; }

	public void enforceRelationships()
	{
		if(this.userRoles != null)
		{
			for(UserRole userRole : this.userRoles)
			{
				userRole.setUser(this);
			}
		}
	}

	public void loadProperties()
	{
		if(this.userRoles != null)
			this.userRoles.size();
	}
}
