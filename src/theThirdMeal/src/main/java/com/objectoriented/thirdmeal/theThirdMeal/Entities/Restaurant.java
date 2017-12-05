package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "Restaurants")
public class Restaurant extends UserItem implements PersistableEntity
{
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "AddressKey")
	private Address address;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PhoneNumberKey")
	private PhoneNumber phoneNumber;

	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
	private List<RestaurantDailyHours> dailyHours;

	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
	private List<Menu> menus;

	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
	private List<Order> orders;

	@Column(name = "Name", nullable = false)
	private String name;

	public Restaurant()
	{
		address = new Address();
		phoneNumber = new PhoneNumber();
		initializeDailyHours();
	}

	public Restaurant(String name, Address address, PhoneNumber phoneNumber,
	                  List<RestaurantDailyHours> dailyHours, List<Menu> menus)
	{
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.dailyHours = dailyHours;
		this.menus = menus;
	}

	public Address getAddress(){ return this.address; }
	public void setAddress(Address address) { this.address = address; }

	public PhoneNumber getPhoneNumber() { return this.phoneNumber; }
	public void setPhoneNumber(PhoneNumber phoneNumber) { this.phoneNumber = phoneNumber; }

	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }

	public List<RestaurantDailyHours> getDailyHours()
	{
		Collections.sort(this.dailyHours);
		return this.dailyHours;
	}

	public List<Menu> getMenus() { return this.menus; }
	public void setMenus(List<Menu> menus) { this.menus = menus; }

	public List<Order> getOrders() { return orders; }
	public void setOrders(List<Order> orders) { this.orders = orders; }

	public RestaurantDailyHours hoursForToday()
	{
		return null;
	}

	public void enforceRelationships()
	{
		if(this.dailyHours != null)
		{
			for(RestaurantDailyHours dailyHours : this.dailyHours)
			{
				dailyHours.setRestaurant(this);
				dailyHours.setUser(this.user);
			}
		}

		if(this.menus != null)
		{
			for(Menu menu : this.menus)
			{
				menu.setRestaurant(this);
				menu.setUser(this.user);
			}
		}

		if(this.address != null)
			this.address.setUser(this.user);

		if(this.phoneNumber != null)
			this.phoneNumber.setUser(this.user);
	}

	public void loadProperties()
	{
		if(this.dailyHours != null)
			this.dailyHours.size();

		if(this.orders != null)
		{
			this.orders.size();
			for(Order order : orders)
			{
				order.loadProperties();
			}
		}

		if(this.menus != null)
		{
			this.menus.size();
			for(Menu menu : menus)
			{
				menu.loadProperties();
			}
		}
	}

	public void initializeDailyHours()
	{
		dailyHours = new ArrayList<>();
		for(DayOfWeek dayOfWeek : DayOfWeek.values())
		{
			dailyHours.add(new RestaurantDailyHours(dayOfWeek, null, null));
		}
	}
}
