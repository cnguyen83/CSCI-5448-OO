package com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Concrete;

import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.IRepository;
import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract.ISearchRepository;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.User;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository implements IRepository<User>, ISearchRepository<User>
{
	@Autowired
	private SessionFactory _sessionFactory;

	@Override
	public boolean create(User object)
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
	public User read(Long entityKey)
	{
		User returnVal;
		try
		{
			Session session = _sessionFactory.openSession();
			returnVal = session.get(User.class, entityKey);

			if(returnVal != null && returnVal.getUserRoles() != null)
				returnVal.getUserRoles().size();

			session.close();
		}
		catch (Exception ex)
		{
			return null;
		}
		return returnVal;
	}

	@Override
	public boolean update(User object)
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
	public boolean delete(User object)
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
	public List<User> search(String searchString)
	{
		List<User> returnVal;
		Session session = _sessionFactory.openSession();
		returnVal = session.createQuery("from User where _username=?")
			.setParameter(0, searchString)
			.list();

		if(returnVal != null)
		{
			for(User user : returnVal)
			{
				if(user.getUserRoles() != null)
					user.getUserRoles().size();
			}
		}

		session.close();

		return returnVal;
	}

}
