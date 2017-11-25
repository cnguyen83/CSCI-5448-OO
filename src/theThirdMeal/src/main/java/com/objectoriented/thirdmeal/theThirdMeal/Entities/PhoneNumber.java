package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;

@Entity
@Table(name = "PhoneNumbers")
public class PhoneNumber extends UserItem
{
	@Column(name = "AreaCode", nullable = false)
	private Integer areaCode;

	@Column(name = "MiddleThreeDigits", nullable = false)
	private Integer middleThreeDigits;

	@Column(name = "LastFourDigits", nullable = false)
	private Integer lastFourDigits;

	public PhoneNumber(){}

	public PhoneNumber(Integer areaCode, Integer middleThreeDigits, Integer lastFourDigits)
	{
		this.areaCode = areaCode;
		this.middleThreeDigits = middleThreeDigits;
		this.lastFourDigits = lastFourDigits;
	}

	public Integer getAreaCode() { return this.areaCode; }
	public void setAreaCode(Integer areaCode) { this.areaCode = areaCode; }

	public Integer getMiddleThreeDigits() { return this.middleThreeDigits; }
	public void setMiddleThreeDigits(Integer middleThreeDigits) { this.middleThreeDigits = middleThreeDigits; }

	public Integer getLastFourDigits() {	return this.lastFourDigits; }
	public void setLastFourDigits(Integer lastFourDigits) { this.lastFourDigits = lastFourDigits; }

	@Override
	public String toString()
	{
		return String.format("(%s) %s-%s", areaCode, middleThreeDigits, lastFourDigits);
	}
}
