package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Addresses")
public class Address extends UserItem
{
	@Column(name = "StreetAddress", nullable = false)
	private String streetAddress;

	@Column(name = "City", nullable = false)
	private String city;

	@Column(name = "State")
	private String stateProvince;

	@Column(name = "Country", nullable = false)
	private String country;

	@Column(name = "Zip")
	private String zip;

	public Address(){}

	public Address(String streetAddress, String city, String stateProvince, String country, String zip)
	{
		this.streetAddress = streetAddress;
		this.city = city;
		this.stateProvince = stateProvince;
		this.country = country;
		this.zip = zip;
	}

	public String getStreetAddress() { return this.streetAddress; }
	public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }

	public String getCity() { return this.city; }
	public void setCity(String city) { this.city = city; }

	public String getStateProvince() {	return this.stateProvince; }
	public void setStateProvince(String stateProvince) { this.stateProvince = stateProvince; }

	public String getCountry() { return this.country; }
	public void setCountry(String country) { this.country = country; }

	public String getZip() { return this.zip; }
	public void setZip(String zip) { this.zip = zip; }
}
