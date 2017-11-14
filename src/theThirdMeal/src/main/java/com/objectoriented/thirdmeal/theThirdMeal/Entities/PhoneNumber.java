package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;

@Entity
@Table(name = "PhoneNumbers")
public class PhoneNumber {

	private short _areaCode;
	private short _middleThreeDigits;
	private short _lastFourDigits;

	@Column(name = "AreaCode")
	public short getAreaCode() { return _areaCode; }
	public void setAreaCode(short areaCode) { _areaCode = areaCode; }

	@Column(name = "MiddleThreeDigits")
	public short getMiddleThreeDigits() { return _middleThreeDigits; }
	public void setMiddleThreeDigits(short middleThreeDigits) { _middleThreeDigits = middleThreeDigits; }

	@Column(name = "LastFourDigits")
	public short getLastFourDigits() {	return _lastFourDigits; }
	public void setLastFourDigits(short lastFourDigits) { _lastFourDigits = lastFourDigits; }
}
