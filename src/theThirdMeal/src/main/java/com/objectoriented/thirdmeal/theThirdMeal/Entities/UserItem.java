package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class UserItem extends UniqueItem
{

	@ManyToOne
	@JoinColumn(name = "UserKey")
	private User _user;

	public User getUser() { return _user; }
	public void setUser(User user) { _user = user; }
}
