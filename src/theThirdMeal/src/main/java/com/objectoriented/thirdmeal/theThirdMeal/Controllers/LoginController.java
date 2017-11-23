package com.objectoriented.thirdmeal.theThirdMeal.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController
{

	@GetMapping("/login")
	public String loginGet()
	{
		return "login";
	}
}
