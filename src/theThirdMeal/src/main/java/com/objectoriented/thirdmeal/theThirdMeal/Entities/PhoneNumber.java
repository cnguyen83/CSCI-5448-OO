package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;

@Entity
@Table(name = "PhoneNumbers")
public class PhoneNumber extends UniqueItem
{

	@Column(name = "AreaCode")
	private int _areaCode;

	@Column(name = "MiddleThreeDigits")
	private int _middleThreeDigits;

	@Column(name = "LastFourDigits")
	private int _lastFourDigits;

	public int getAreaCode() { return _areaCode; }
	public void setAreaCode(int areaCode) { _areaCode = areaCode; }

	public int getMiddleThreeDigits() { return _middleThreeDigits; }
	public void setMiddleThreeDigits(int middleThreeDigits) { _middleThreeDigits = middleThreeDigits; }

	public int getLastFourDigits() {	return _lastFourDigits; }
	public void setLastFourDigits(int lastFourDigits) { _lastFourDigits = lastFourDigits; }
}
