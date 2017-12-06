package com.objectoriented.thirdmeal.theThirdMeal.Controllers;

import com.objectoriented.thirdmeal.theThirdMeal.Authentication.UserService;
import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.IRepository;
import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.IRestaurantItemRepository;
import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.IUserItemRepository;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.Order;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.OrderStatus;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RestaurantOwnerHomeController
{
	@Autowired
	IUserItemRepository<Restaurant> userRestaurantRepository;

	@Autowired
	IRepository<Order> orderRepository;

	@GetMapping("/restaurantOwnerHome")
	public String restaurantOwnerHomeGet(Model model)
	{
		List<Restaurant> restaurants = userRestaurantRepository.readAllForCurrentUser();

		if(restaurants == null || restaurants.isEmpty())
			return "redirect:/restaurantCreateEdit";

		Restaurant restaurant = restaurants.get(0);

		model.addAttribute("restaurant", restaurant);
		model.addAttribute("orderKey", new Long(0L));
		model.addAttribute("orderStatus", OrderStatus.Completed);
		return "restaurantOwnerHome";
	}

	@PostMapping("/restaurantOwnerHome")
	public String restaurantOwnerHomePost(Long orderKey, OrderStatus orderStatus)
	{
		Order order = orderRepository.read(orderKey);

		if(order == null)
			return "redirect:/error";

		order.setOrderStatus(orderStatus);

		if(!orderRepository.save(order))
			return "redirect:/error";

		return "redirect:/restaurantOwnerHome";
	}
}
