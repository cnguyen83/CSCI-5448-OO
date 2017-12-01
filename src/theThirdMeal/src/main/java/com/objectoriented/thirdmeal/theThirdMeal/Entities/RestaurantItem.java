package com.objectoriented.thirdmeal.theThirdMeal.Entities;


import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class RestaurantItem extends UserItem
{
	@ManyToOne
	@JoinColumn(name = "RestaurantKey", nullable = false)
	protected Restaurant restaurant;

	public Restaurant getRestaurant() { return restaurant; }
	public void setRestaurant(Restaurant restaurant) { this.restaurant = restaurant; }
}
