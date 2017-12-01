package com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract;

import com.objectoriented.thirdmeal.theThirdMeal.Entities.UserItem;

import java.util.List;

public interface IUserItemRepository<T extends UserItem>
{
	List<T> readAllForCurrentUser();
}
