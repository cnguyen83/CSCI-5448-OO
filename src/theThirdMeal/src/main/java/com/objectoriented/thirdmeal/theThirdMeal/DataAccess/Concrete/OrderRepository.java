package com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Concrete;

import com.objectoriented.thirdmeal.theThirdMeal.Authentication.UserService;
import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.IRepository;
import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.IUserItemRepository;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.Menu;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderRepository implements IUserItemRepository<Order>
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean save(Order object)
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
	public Order read(Long entityKey)
	{
		Order returnVal;
		try
		{
			Session session = sessionFactory.openSession();
			returnVal = session.get(Order.class, entityKey);

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
	public boolean delete(Order object)
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
	public List<Order> readAllForCurrentUser() {
		return null;
	}
}
