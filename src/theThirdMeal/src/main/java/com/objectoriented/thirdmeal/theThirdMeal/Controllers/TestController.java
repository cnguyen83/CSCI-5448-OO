package com.objectoriented.thirdmeal.theThirdMeal.Controllers;

import com.objectoriented.thirdmeal.theThirdMeal.Authentication.UserService;
import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.ISearchRepository;
import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.IUserItemRepository;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@Autowired
	IUserItemRepository<Restaurant> restaurantRepository;

	@Autowired
	ISearchRepository<Restaurant> restaurantSearchRepository;

	@GetMapping("/hello")
	public String hello(Model model)
	{
		model.addAttribute("username", UserService.getCurrentUser().getUsername());
		return "hello";
	}

}
