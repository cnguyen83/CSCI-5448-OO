package com.objectoriented.thirdmeal.theThirdMeal.DataAccessTests;

import com.objectoriented.thirdmeal.theThirdMeal.DataAccess.HibernateSetup;
import com.objectoriented.thirdmeal.theThirdMeal.Entities.PhoneNumber;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateSetup.getSessionFactory();

		Session session = sessionFactory.openSession();

		session.beginTransaction();

		PhoneNumber phoneNumber = new PhoneNumber();
		phoneNumber.setAreaCode(303);
		phoneNumber.setMiddleThreeDigits(123);
		phoneNumber.setLastFourDigits(4567);

		session.save(phoneNumber);

		session.getTransaction().commit();

		session.close();
		sessionFactory.close();
	}
}
