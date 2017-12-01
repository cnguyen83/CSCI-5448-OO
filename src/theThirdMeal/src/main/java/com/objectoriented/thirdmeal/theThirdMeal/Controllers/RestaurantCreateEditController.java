package com.objectoriented.thirdmeal.theThirdMeal.Controllers;

import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.IRepository;
import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.IUserItemRepository;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.Restaurant;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.RestaurantDailyHours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

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

		if(restaurant.getDailyHours() == null || restaurant.getDailyHours().isEmpty())
			restaurant.initializeDailyHours();

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
