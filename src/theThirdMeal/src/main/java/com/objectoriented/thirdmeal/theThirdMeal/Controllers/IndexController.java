package com.objectoriented.thirdmeal.theThirdMeal.Controllers;

import com.objectoriented.thirdmeal.theThirdMeal.Authentication.UserService;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.User;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.UserRole;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.UserRolesEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController
{
	@GetMapping("/")
	public String indexGet() throws Exception
	{
		User currentUser = UserService.getCurrentUser();
		if(currentUser.getUserRoles() != null && !currentUser.getUserRoles().isEmpty())
		{
			UserRolesEnum role = currentUser.getUserRoles().get(0).getRole();
			if(role == UserRolesEnum.CUSTOMER)
				return "redirect:/customerHome";
			else if(role == UserRolesEnum.RESTAURANT_OWNER)
				return "redirect:/restaurantOwnerHome";
		}

		throw new Exception("The user does not have a supported role.");
	}
}
