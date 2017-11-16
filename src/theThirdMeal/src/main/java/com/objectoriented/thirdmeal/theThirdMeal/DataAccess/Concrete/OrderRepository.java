package com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Concrete;

import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.IRepository;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.Menu;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.Order;
import org.hibernate.Session;

public class OrderRepository implements IRepository<Order>
{
	private Session _session;

	public OrderRepository(Session session)
	{
		if(session == null || !session.isOpen())
			throw new IllegalArgumentException("The provided session was null or not open.");

		_session = session;
	}

	@Override
	public boolean create(Order object)
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
	public Order read(Long entityKey)
	{
		Order returnVal;
		try
		{
			returnVal = _session.get(Order.class, entityKey);
		}
		catch (Exception ex)
		{
			return null;
		}
		return returnVal;
	}

	@Override
	public boolean update(Order object)
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
	public boolean delete(Order object)
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
}
