package com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Concrete;

import com.objectoriented.thirdmeal.theThirdMeal.Authentication.UserService;
import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.IRepository;
import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.ISearchRepository;
import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.IUserItemRepository;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.Menu;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.Restaurant;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RestaurantRepository implements IUserItemRepository<Restaurant>, ISearchRepository<Restaurant>
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean save(Restaurant object)
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
	public Restaurant read(Long entityKey)
	{
		Restaurant returnVal;
		try
		{
			Session session = sessionFactory.openSession();
			returnVal = session.get(Restaurant.class, entityKey);

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
	public boolean delete(Restaurant object)
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
	public List<Restaurant> readAllForCurrentUser() {
		List<Restaurant> returnVal;
		Session session = sessionFactory.openSession();
		returnVal = session.createQuery("from Restaurant where user.key=?")
			.setParameter(0, UserService.getCurrentUser().getKey())
			.list();

		if(returnVal != null)
		{
			for(Restaurant restaurant : returnVal)
			{
				if(restaurant != null)
					restaurant.loadProperties();
			}
		}

		session.close();

		return returnVal;
	}

	@Override
	public List<Restaurant> search(String searchString)
	{
		List<Restaurant> returnVal;
		Session session = sessionFactory.openSession();
		returnVal = session.createQuery("from Restaurant where name like ?")
			.setParameter(0, "%" + searchString + "%")
			.list();

		if(returnVal != null)
		{
			for(Restaurant restaurant : returnVal)
			{
				if(restaurant != null)
					restaurant.loadProperties();
			}
		}

		session.close();

		return returnVal;
	}
}
