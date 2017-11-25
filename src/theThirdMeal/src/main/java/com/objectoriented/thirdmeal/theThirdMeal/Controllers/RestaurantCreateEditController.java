package com.objectoriented.thirdmeal.theThirdMeal.Controllers;

import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.IRepository;
import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.IUserItemRepository;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RestaurantCreateEditController
{
	@Autowired
	IRepository<Restaurant> restaurantRepository;

	@Autowired
	IUserItemRepository<Restaurant> userRestaurantRepository;

	@GetMapping("/restaurantCreateEdit")
	public String restaurantCreateEditGet(Model model)
	{
		List<Restaurant> restaurants = userRestaurantRepository.readAllForCurrentUser();

		Restaurant restaurant = new Restaurant();
		if(restaurants != null && !restaurants.isEmpty())
			restaurant = restaurants.get(0);

		model.addAttribute("restaurant", restaurant);
		return "restaurantCreateEdit";
	}

	@PostMapping("/restaurantCreateEdit")
	public String restaurantCreateEditPost(@ModelAttribute Restaurant restaurant)
	{
		if(!restaurantRepository.save(restaurant))
			return "redirect:/error";

		return "redirect:/restaurantOwnerHome";
	}
}
