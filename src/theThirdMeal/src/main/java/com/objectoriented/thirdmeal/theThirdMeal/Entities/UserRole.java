package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;

@Entity
@Table(name = "UserRoles")
public class UserRole extends UserItem
{

	@Enumerated(EnumType.STRING)
	@Column(name = "UserRole")
	private UserRolesEnum _role;

	public UserRolesEnum getRole() { return _role; }
	public void setRole(UserRolesEnum role) { _role = role; }
}
