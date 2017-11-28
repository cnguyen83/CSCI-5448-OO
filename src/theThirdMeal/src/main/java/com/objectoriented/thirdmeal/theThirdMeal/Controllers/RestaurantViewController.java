package com.objectoriented.thirdmeal.theThirdMeal.Controllers;

import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.IRepository;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RestaurantViewController
{
	@Autowired
	IRepository<Restaurant> restaurantRepository;

	@GetMapping("/restaurantView")
	public String restaurantViewGet(Model model, @RequestParam Long restaurantKey)
	{
		Restaurant restaurant = restaurantRepository.read(restaurantKey);
		model.addAttribute("restaurant", restaurant);

		return "restaurantView";
	}
}
