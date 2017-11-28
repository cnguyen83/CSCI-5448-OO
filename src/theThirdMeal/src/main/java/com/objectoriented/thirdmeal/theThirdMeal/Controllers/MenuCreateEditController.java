package com.objectoriented.thirdmeal.theThirdMeal.Controllers;

import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.IRepository;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.Menu;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MenuCreateEditController
{
	@Autowired
	IRepository<Menu> menuRepository;

	@Autowired
	IRepository<Restaurant> restaurantRepository;

	@GetMapping("/menuCreateEdit")
	public String menuCreateEditGet(Model model, @RequestParam Long restaurantKey,
        @RequestParam(required = false) Long menuKey)
	{
		Restaurant restaurant = restaurantRepository.read(restaurantKey);

		Menu menu = new Menu();
		menu.setRestaurant(restaurant);

		model.addAttribute("menu", menu);
		return "menuCreateEdit";
	}

	@PostMapping("/menuCreateEdit")
	public String menuCreateEditPost(@ModelAttribute Menu menu)
	{
		if(!menuRepository.save(menu))
			return "redirect:/error";

		return "redirect:/restaurantOwnerHome";
	}
}
