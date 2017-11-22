package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;
import java.util.Date;
import java.time.DayOfWeek;

@Entity
@Table(name = "RestaurantDailyHours")
public class RestaurantDailyHours extends UserItem
{
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "DayOfWeek", nullable = false)
	private DayOfWeek dayOfWeek;

	@Temporal(TemporalType.TIME)
	@Column(name = "StartTime", nullable = false)
	private Date startTime;

	@Temporal(TemporalType.TIME)
	@Column(name = "StopTime", nullable = false)
	private Date stopTime;

	@ManyToOne
	@JoinColumn(name = "RestaurantKey", nullable = false)
	private Restaurant restaurant;

	public RestaurantDailyHours(){}

	public RestaurantDailyHours(DayOfWeek dayOfWeek, Date startTime, Date stopTime)
	{
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.stopTime = stopTime;
	}

	public DayOfWeek getDayOfWeek() { return this.dayOfWeek; }
	public void setDayOfWeek(DayOfWeek dayOfWeek) { this.dayOfWeek = dayOfWeek; }

	public Date getStartTime() { return this.startTime; }
	public void setStartTime(Date startTime) { this.startTime = startTime; }

	public Date getStopTime() { return this.stopTime; }
	public void setStopTime(Date stopTime) { this.stopTime = stopTime; }

	public Restaurant getRestaurant() { return this.restaurant; }
	public void setRestaurant(Restaurant restaurant) { this.restaurant = restaurant; }
}
