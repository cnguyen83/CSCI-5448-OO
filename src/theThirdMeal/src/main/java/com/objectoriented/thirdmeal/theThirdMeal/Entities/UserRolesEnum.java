package com.objectoriented.thirdmeal.theThirdMeal.Entities;

public enum UserRolesEnum
{
	CUSTOMER("Customer"),
	RESTAURANT_OWNER("Restaurant Owner");

	private String displayName;

	UserRolesEnum(String displayName)
	{
		this.displayName = displayName;
	}

	public String display()
	{
		return displayName;
	}
}
