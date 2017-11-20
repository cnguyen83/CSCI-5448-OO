package com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Concrete;

import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.IRepository;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.Menu;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuRepository implements IRepository<Menu>
{
	@Autowired
	private SessionFactory _sessionFactory;

	@Override
	public boolean create(Menu object)
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
	public Menu read(Long entityKey)
	{
		Menu returnVal;
		try
		{
			Session session = _sessionFactory.openSession();
			returnVal = session.get(Menu.class, entityKey);

			if(returnVal != null && returnVal.getMenuItems() != null)
				returnVal.getMenuItems().size();

			session.close();
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
	public boolean delete(Menu object)
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
}
