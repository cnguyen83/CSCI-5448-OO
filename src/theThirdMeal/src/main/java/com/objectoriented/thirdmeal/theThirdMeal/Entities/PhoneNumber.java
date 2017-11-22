package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;

@Entity
@Table(name = "PhoneNumbers")
public class PhoneNumber extends UserItem
{
	@Column(name = "AreaCode", nullable = false)
	private Integer _areaCode;

	@Column(name = "MiddleThreeDigits", nullable = false)
	private Integer _middleThreeDigits;

	@Column(name = "LastFourDigits", nullable = false)
	private Integer _lastFourDigits;

	public PhoneNumber(){}

	public PhoneNumber(Integer areaCode, Integer middleThreeDigits, Integer lastFourDigits)
	{
		_areaCode = areaCode;
		_middleThreeDigits = middleThreeDigits;
		_lastFourDigits = lastFourDigits;
	}

	public Integer getAreaCode() { return _areaCode; }
	public void setAreaCode(Integer areaCode) { _areaCode = areaCode; }

	public Integer getMiddleThreeDigits() { return _middleThreeDigits; }
	public void setMiddleThreeDigits(Integer middleThreeDigits) { _middleThreeDigits = middleThreeDigits; }

	public Integer getLastFourDigits() {	return _lastFourDigits; }
	public void setLastFourDigits(Integer lastFourDigits) { _lastFourDigits = lastFourDigits; }
}
