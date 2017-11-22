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
	private DayOfWeek _dayOfWeek;

	@Temporal(TemporalType.TIME)
	@Column(name = "StartTime", nullable = false)
	private Date _startTime;

	@Temporal(TemporalType.TIME)
	@Column(name = "StopTime", nullable = false)
	private Date _stopTime;

	@ManyToOne
	@JoinColumn(name = "RestaurantKey", nullable = false)
	private Restaurant _restaurant;

	public RestaurantDailyHours(){}

	public RestaurantDailyHours(DayOfWeek dayOfWeek, Date startTime, Date stopTime)
	{
		_dayOfWeek = dayOfWeek;
		_startTime = startTime;
		_stopTime = stopTime;
	}

	public DayOfWeek getDayOfWeek() { return _dayOfWeek; }
	public void setDayOfWeek(DayOfWeek dayOfWeek) { _dayOfWeek = dayOfWeek; }

	public Date getStartTime() { return _startTime; }
	public void setStartTime(Date startTime) { _startTime = startTime; }

	public Date getStopTime() { return _stopTime; }
	public void setStopTime(Date stopTime) { _stopTime = stopTime; }

	public Restaurant getRestaurant() { return _restaurant; }
	public void setRestaurant(Restaurant restaurant) { _restaurant = restaurant; }
}
