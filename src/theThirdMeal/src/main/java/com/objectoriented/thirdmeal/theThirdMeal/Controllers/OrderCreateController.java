package com.objectoriented.thirdmeal.theThirdMeal.Controllers;

import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.IRepository;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.Menu;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.Order;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.OrderStatus;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class OrderCreateController
{
	@Autowired
	IRepository<Order> orderRepository;

	@Autowired
	IRepository<Restaurant> restaurantRepository;

	@GetMapping("/orderCreate")
	public String orderCreateGet(Model model, @RequestParam Long restaurantKey)
	{
		Restaurant restaurant = restaurantRepository.read(restaurantKey);

		Order order = new Order();
		order.setRestaurant(restaurant);

		model.addAttribute("restaurantKey", restaurant.getKey());
		model.addAttribute("order", order);

		return "orderCreate";
	}

	@PostMapping("/orderCreate")
	public String orderCreatePost(@ModelAttribute Order order)
	{
		order.setCreatedTime(new Date());
		order.setOrderStatus(OrderStatus.Open);

		if(!orderRepository.save(order))
		{
			return "/error";
		}

		return "redirect:/customerHome";
	}
}
