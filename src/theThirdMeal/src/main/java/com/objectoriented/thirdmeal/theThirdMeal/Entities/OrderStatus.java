package com.objectoriented.thirdmeal.theThirdMeal.Entities;

public enum OrderStatus {
	Open("Open"),
	InProgress("In Progress"),
	Completed("Completed"),
	Cancelled("Cancelled");

	private String displayName;

	OrderStatus(String displayName){ this.displayName = displayName; }

	public String display() { return displayName; }
}
