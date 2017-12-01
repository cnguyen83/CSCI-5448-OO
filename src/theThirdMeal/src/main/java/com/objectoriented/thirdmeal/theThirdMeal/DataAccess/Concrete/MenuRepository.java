package com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Concrete;

import com.objectoriented.thirdmeal.theThirdMeal.Authentication.UserService;
import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.IRepository;
import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.IRestaurantItemRepository;
import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.IUserItemRepository;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.Menu;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MenuRepository implements IRepository<Menu>, IRestaurantItemRepository<Menu>
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean save(Menu object)
	{
		try
		{
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			object.setUser(UserService.getCurrentUser());
			object.enforceRelationships();
			session.saveOrUpdate(object);
			session.flush();
			session.getTransaction().commit();
			session.close();
		}
		catch (Exception ex)
		{
			return false;
		}

		return true;
	}

	@Override
	public Menu read(Long entityKey)
	{
		Menu returnVal;
		try
		{
			Session session = sessionFactory.openSession();
			returnVal = session.get(Menu.class, entityKey);

			if(returnVal != null)
				returnVal.loadProperties();

			session.close();
		}
		catch (Exception ex)
		{
			return null;
		}
		return returnVal;
	}

	@Override
	public boolean delete(Menu object)
	{
		try
		{
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			object.setUser(UserService.getCurrentUser());
			object.enforceRelationships();
			session.delete(object);
			session.flush();
			session.getTransaction().commit();
			session.close();
		}
		catch (Exception ex)
		{
			return false;
		}

		return true;
	}

	@Override
	public List<Menu> readAllForRestaurant(Long restaurantKey)
	{

		List<Menu> returnVal;
		Session session = sessionFactory.openSession();
		returnVal = session.createQuery("from Menu where restaurant.key=?")
			.setParameter(0, restaurantKey)
			.list();

		if(returnVal != null)
		{
			for(Menu menu : returnVal)
			{
				if(menu != null)
					menu.loadProperties();
			}
		}

		session.close();

		return returnVal;
	}
}
