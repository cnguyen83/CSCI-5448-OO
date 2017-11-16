package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Restaurants")
public class Restaurant extends UniqueItem
{

	@OneToOne
	@JoinColumn(name = "AddressKey")
	private Address _address;

	@OneToOne
	@JoinColumn(name = "PhoneNumberKey")
	private PhoneNumber _phoneNumber;

	@OneToMany(mappedBy = "_restaurant")
	private List<RestaurantDailyHours> _dailyHours;

	@OneToMany(mappedBy = "_restaurant")
	private List<Menu> _menus;

	@Column(name = "Name")
	private String _name;

	public Address getAddress(){ return _address; }
	public void setAddress(Address address) { _address = address; }

	public PhoneNumber getPhoneNumber() { return _phoneNumber; }
	public void setPhoneNumber(PhoneNumber phoneNumber) { _phoneNumber = phoneNumber; }

	public String getName() { return _name; }
	public void setName(String name) { _name = name; }

	public List<RestaurantDailyHours> getDailyHours() { return _dailyHours; }
	public void setDailyHours(List<RestaurantDailyHours> dailyHours) { _dailyHours = dailyHours; }

	public List<Menu> getMenus() { return _menus; }
	public void setMenus(List<Menu> menus) { _menus = menus; }
}
