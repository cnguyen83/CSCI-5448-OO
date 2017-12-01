package com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract;

import com.objectoriented.thirdmeal.theThirdMeal.Entities.RestaurantItem;

import java.util.List;

public interface IRestaurantItemRepository<T extends RestaurantItem>
{
	List<T> readAllForRestaurant(Long restaurantKey);
}
