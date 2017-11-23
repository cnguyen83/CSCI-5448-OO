package com.objectoriented.thirdmeal.theThirdMeal.Controllers;

import com.objectoriented.thirdmeal.theThirdMeal.Authentication.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestaurantOwnerHome
{
	@GetMapping("/restaurantOwnerHome")
	public String restaurantOwnerHomeGet(Model model)
	{
		model.addAttribute("username", UserService.getCurrentUser().getUsername());
		return "restaurantOwnerHome";
	}
}
