package com.objectoriented.thirdmeal.theThirdMeal.DataAccessTests;

import com.objectoriented.thirdmeal.theThirdMeal.Authentication.UserService;
import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.IRepository;
import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Concrete.UserRepository;
import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.HibernateSetup;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.PhoneNumber;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.User;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.UserRole;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.UserRolesEnum;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HibernateTest {

	@Autowired
	private UserService userService;

	@Autowired
	private IRepository<User> userRepository;

	@Test
	public void hibernateTest() {
		SessionFactory sessionFactory = HibernateSetup.getSessionFactory();

		User user = new User();

		user.setUsername("hello");
		user.setPassword("password");

		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(UserRolesEnum.CUSTOMER);

		ArrayList<UserRole> userRoles = new ArrayList<>();
		userRoles.add(userRole);

		user.setUserRoles(userRoles);

		userRepository.create(user);

		UserDetails returnedUser = userService.loadUserByUsername("hello");

		sessionFactory.close();
	}
}
