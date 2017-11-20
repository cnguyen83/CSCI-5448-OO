package com.objectoriented.thirdmeal.theThirdMeal.DataAccess;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class HibernateSetup {

	private static SessionFactory sessionFactory;

	@Bean
	public static synchronized SessionFactory getSessionFactory()
	{
		if(sessionFactory == null)
			setup();

		return sessionFactory;
	}

	public static synchronized void setup()
	{
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure("hibernate.cfg.xml").build();

		try
		{
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		}
		catch (Exception ex)
		{
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
}
