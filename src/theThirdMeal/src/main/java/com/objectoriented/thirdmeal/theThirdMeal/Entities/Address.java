package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Addresses")
public class Address {

	private String _streetAddress;
	private String _city;
	private String _stateProvince;
	private String _country;
	private String _zip;

	@Column(name = "StreetAddress")
	public String getStreetAddress() { return _streetAddress; }
	public void setStreetAddress(String streetAddress) { _streetAddress = streetAddress; }

	@Column(name = "City")
	public String getCity() { return _city; }
	public void setCity(String city) { _city = city; }

	@Column(name = "State")
	public String getStateProvince() {	return _stateProvince; }
	public void setStateProvince(String stateProvince) { _stateProvince = stateProvince; }

	@Column(name = "Country")
	public String getCountry() { return _country; }
	public void setCountry(String country) { _country = country; }

	@Column(name = "Zip")
	public String getZip() { return _zip; }
	public void setZip(String zip) { _zip = zip; }
}
