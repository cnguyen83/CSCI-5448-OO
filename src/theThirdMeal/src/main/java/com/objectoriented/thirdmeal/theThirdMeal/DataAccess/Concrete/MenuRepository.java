package com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Concrete;

import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.IRepository;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.Menu;
import org.hibernate.Session;

public class MenuRepository implements IRepository<Menu>
{
	private Session _session;

	public MenuRepository(Session session)
	{
		if(session == null || !session.isOpen())
			throw new IllegalArgumentException("The provided session was null or not open.");

		_session = session;
	}

	@Override
	public boolean create(Menu object)
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
	public Menu read(Long entityKey)
	{
		Menu returnVal;
		try
		{
			returnVal = _session.get(Menu.class, entityKey);
		}
		catch (Exception ex)
		{
			return null;
		}
		return returnVal;
	}

	@Override
	public boolean update(Menu object)
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
	public boolean delete(Menu object)
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
