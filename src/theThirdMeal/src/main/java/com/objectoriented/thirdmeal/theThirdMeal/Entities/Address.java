package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Addresses")
public class Address extends UserItem
{

	@Column(name = "StreetAddress")
	private String _streetAddress;

	@Column(name = "City")
	private String _city;

	@Column(name = "State")
	private String _stateProvince;

	@Column(name = "Country")
	private String _country;

	@Column(name = "Zip")
	private String _zip;

	public String getStreetAddress() { return _streetAddress; }
	public void setStreetAddress(String streetAddress) { _streetAddress = streetAddress; }

	public String getCity() { return _city; }
	public void setCity(String city) { _city = city; }

	public String getStateProvince() {	return _stateProvince; }
	public void setStateProvince(String stateProvince) { _stateProvince = stateProvince; }

	public String getCountry() { return _country; }
	public void setCountry(String country) { _country = country; }

	public String getZip() { return _zip; }
	public void setZip(String zip) { _zip = zip; }
}
