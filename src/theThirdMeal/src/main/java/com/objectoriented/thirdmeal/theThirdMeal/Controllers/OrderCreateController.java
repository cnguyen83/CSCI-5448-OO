package com.objectoriented.thirdmeal.theThirdMeal.Controllers;

import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.IRepository;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
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

		if(restaurant == null)
			return "redirect:/error";

		Order order = new Order();

		ArrayList<OrderItem> orderItems = new ArrayList<>();

		for(Menu menu : restaurant.getMenus())
		{
			for(MenuItem menuItem : menu.getMenuItems())
			{
				orderItems.add(new OrderItem(0, menuItem, order));
			}
		}

		order.setOrderItems(orderItems);
		order.setRestaurant(restaurant);

		model.addAttribute("order", order);

		return "orderCreate";
	}

	@PostMapping("/orderCreate")
	public String orderCreatePost(@ModelAttribute Order order)
	{
		order.setCreatedTime(new Date());
		order.setOrderStatus(OrderStatus.Open);

		order.removeEmptyOrderItems();

		order.setCost(order.calculateCost());

		if(!orderRepository.save(order))
			return "redirect:/error";

		return "redirect:/customerHome";
	}
}
