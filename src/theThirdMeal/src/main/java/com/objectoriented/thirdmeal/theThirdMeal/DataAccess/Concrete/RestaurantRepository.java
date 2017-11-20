package com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Concrete;

import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.IRepository;
import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.ISearchRepository;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.Menu;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.Restaurant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RestaurantRepository implements IRepository<Restaurant>, ISearchRepository<Restaurant>
{
	@Autowired
	private SessionFactory _sessionFactory;

	@Override
	public boolean create(Restaurant object)
	{
		try
		{
			Session session = _sessionFactory.openSession();
			session.beginTransaction();
			session.save(object);
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
			Session session = _sessionFactory.openSession();
			returnVal = session.get(Restaurant.class, entityKey);

			if(returnVal != null && returnVal.getDailyHours() != null)
				returnVal.getDailyHours().size();

			if(returnVal != null && returnVal.getMenus() != null)
				returnVal.getMenus().size();

			session.close();
		}
		catch (Exception ex)
		{
			return null;
		}
		return returnVal;
	}

	@Override
	public boolean update(Restaurant object)
	{
		try
		{
			Session session = _sessionFactory.openSession();
			session.beginTransaction();
			session.update(object);
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
	public boolean delete(Restaurant object)
	{
		try
		{
			Session session = _sessionFactory.openSession();
			session.beginTransaction();
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
	public List<Restaurant> search(String searchString)
	{
		return null;
	}
}
