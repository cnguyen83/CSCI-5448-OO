package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class UserItem extends UniqueItem
{
	@ManyToOne
	@JoinColumn(name = "UserKey", nullable = false)
	protected User user;

	public User getUser() { return this.user; }
	public void setUser(User user) { this.user = user; }
}
