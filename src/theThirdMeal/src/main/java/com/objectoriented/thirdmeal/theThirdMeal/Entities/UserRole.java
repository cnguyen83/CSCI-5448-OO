package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;

@Entity
@Table(name = "UserRoles")
public class UserRole extends UserItem
{
	@Enumerated(EnumType.STRING)
	@Column(name = "UserRole", nullable = false)
	private UserRolesEnum role;

	public UserRole(){}

	public UserRole(UserRolesEnum role)
	{
		this.role = role;
	}

	public UserRolesEnum getRole() { return this.role; }
	public void setRole(UserRolesEnum role) { this.role = role; }
}
