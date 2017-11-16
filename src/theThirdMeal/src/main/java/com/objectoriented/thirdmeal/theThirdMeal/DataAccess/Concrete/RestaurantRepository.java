package com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Concrete;

import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.IRepository;
import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.ISearchRepository;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.Menu;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.Restaurant;
import org.hibernate.Session;

import java.util.List;

public class RestaurantRepository implements IRepository<Restaurant>, ISearchRepository<Restaurant>
{
	private Session _session;

	public RestaurantRepository(Session session)
	{
		if(session == null || !session.isOpen())
			throw new IllegalArgumentException("The provided session was null or not open.");

		_session = session;
	}

	@Override
	public boolean create(Restaurant object)
	{
		try
		{
			_session.save(object);
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
			returnVal = _session.get(Restaurant.class, entityKey);
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
			_session.update(object);
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
			_session.delete(object);
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
