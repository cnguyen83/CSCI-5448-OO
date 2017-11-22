package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;

@Entity
@Table(name = "UserRoles")
public class UserRole extends UserItem
{
	@Enumerated(EnumType.STRING)
	@Column(name = "UserRole", nullable = false)
	private UserRolesEnum _role;

	public UserRole(){}

	public UserRole(UserRolesEnum role)
	{
		_role = role;
	}

	public UserRolesEnum getRole() { return _role; }
	public void setRole(UserRolesEnum role) { _role = role; }
}
