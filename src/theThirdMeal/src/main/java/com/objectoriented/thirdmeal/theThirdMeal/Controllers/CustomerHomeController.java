package com.objectoriented.thirdmeal.theThirdMeal.Controllers;

import com.objectoriented.thirdmeal.theThirdMeal.Authentication.UserService;
import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.ISearchRepository;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerHomeController
{
	@Autowired
	ISearchRepository<Restaurant> restaurantSearchRepository;

	@GetMapping("/customerHome")
	public String customerHomeGet(Model model, @RequestParam(required = false) String searchString)
	{
		model.addAttribute("username", UserService.getCurrentUser().getUsername());
		List<Restaurant> restaurants = restaurantSearchRepository.search(searchString);

		if(restaurants == null)
			model.addAttribute("restaurants", new ArrayList<Restaurant>());
		else
			model.addAttribute("restaurants", restaurants);

		return "customerHome";
	}
}
