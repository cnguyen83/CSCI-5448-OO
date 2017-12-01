package com.objectoriented.thirdmeal.theThirdMeal.Controllers;

import com.objectoriented.thirdmeal.theThirdMeal.Authentication.UserService;
import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.IRepository;
import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.IRestaurantItemRepository;
import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.IUserItemRepository;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.Order;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RestaurantOwnerHome
{
	@Autowired
	IUserItemRepository<Restaurant> userRestaurantRepository;

	@Autowired
	IRestaurantItemRepository<Order> restaurantOrderRepository;

	@GetMapping("/restaurantOwnerHome")
	public String restaurantOwnerHomeGet(Model model)
	{
		List<Restaurant> restaurants = userRestaurantRepository.readAllForCurrentUser();

		if(restaurants == null || restaurants.isEmpty())
			return "redirect:/restaurantCreateEdit";

		Restaurant restaurant = restaurants.get(0);

		List<Order> orders = restaurantOrderRepository.readAllForRestaurant(restaurant.getKey());
		if(orders == null)
			orders = new ArrayList<>();


		model.addAttribute("username", UserService.getCurrentUser().getUsername());
		model.addAttribute("restaurant", restaurant);
		model.addAttribute("orders", orders);
		return "restaurantOwnerHome";
	}
}
