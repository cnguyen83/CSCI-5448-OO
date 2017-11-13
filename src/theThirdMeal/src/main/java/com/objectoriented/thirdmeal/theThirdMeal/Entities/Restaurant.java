package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Restaurants")
public class Restaurant {

	private Address _address;
	private PhoneNumber _phoneNumber;
	private String _name;

	@OneToOne
	public Address getAddress(){ return _address; }
	public void setAddress(Address address) { _address = address; }

	@OneToOne
	public PhoneNumber getPhoneNumber() { return _phoneNumber; }
	public void setPhoneNumber(PhoneNumber phoneNumber) { _phoneNumber = phoneNumber; }

	@Column(name = "Name")
	public String getName() { return _name; }
	public void setName(String name) { _name = name; }
}
