package com.objectoriented.thirdmeal.theThirdMeal.Controllers;

import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.IRepository;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.User;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.UserRole;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.UserRolesEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class SignUpController
{
	@Autowired
	IRepository<User> userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping("/signup")
	public String signupGet(Model model)
	{
		model.addAttribute("user", new User());
		model.addAttribute("userRole", new UserRole());
		return "signup";
	}

	@PostMapping("/signup")
	public String signupPost(@ModelAttribute User user, @ModelAttribute UserRole userRole)
	{
		User userToSave = new User(user.getUsername(),
			passwordEncoder.encode(user.getPassword()),
			Arrays.asList(userRole));

		if(userRepository.create(userToSave))
			return "redirect:/hello";
		else
			return "error";
	}
}
