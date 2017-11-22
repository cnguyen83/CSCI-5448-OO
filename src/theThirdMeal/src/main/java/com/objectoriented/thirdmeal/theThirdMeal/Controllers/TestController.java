package com.objectoriented.thirdmeal.theThirdMeal.Controllers;

import com.objectoriented.thirdmeal.theThirdMeal.Authentication.ThirdMealUserDetails;
import com.objectoriented.thirdmeal.theThirdMeal.Authentication.UserService;
import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.IRepository;
import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.ISearchRepository;
import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.IUserItemRepository;
import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Concrete.MenuRepository;
import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Concrete.RestaurantRepository;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
public class TestController {

	@Autowired
	IUserItemRepository<Restaurant> restaurantRepository;

	@Autowired
	ISearchRepository<Restaurant> restaurantSearchRepository;

	@RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public String index()
	{
		Restaurant restaurant = new Restaurant("testing", null, null, null, null);
		restaurant.setUser(UserService.getCurrentUser());

		restaurantRepository.create(restaurant);

		List<Restaurant> writtenRestaurant = restaurantRepository.readAllForCurrentUser();

		List<Restaurant> foundRestaurants = restaurantSearchRepository.search("est");

		return writtenRestaurant.get(0).getName() + "|" + foundRestaurants.get(0).getName();
	}

}
