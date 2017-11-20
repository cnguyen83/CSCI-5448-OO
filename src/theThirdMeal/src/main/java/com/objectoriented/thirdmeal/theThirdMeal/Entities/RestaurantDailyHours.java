package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;
import java.util.Date;
import java.time.DayOfWeek;

@Entity
@Table(name = "RestaurantDailyHours")
public class RestaurantDailyHours extends UserItem
{

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "DayOfWeek")
	private DayOfWeek _dayOfWeek;

	@Temporal(TemporalType.TIME)
	@Column(name = "StartTime")
	private Date _startTime;

	@Temporal(TemporalType.TIME)
	@Column(name = "StopTime")
	private Date _stopTime;

	@ManyToOne
	@JoinColumn(name = "RestaurantKey")
	private Restaurant _restaurant;

	public DayOfWeek getDayOfWeek() { return _dayOfWeek; }
	public void setDayOfWeek(DayOfWeek dayOfWeek) { _dayOfWeek = dayOfWeek; }

	public Date getStartTime() { return _startTime; }
	public void setStartTime(Date startTime) { _startTime = startTime; }

	public Date getStopTime() { return _stopTime; }
	public void setStopTime(Date stopTime) { _stopTime = stopTime; }

	public Restaurant getRestaurant() { return _restaurant; }
	public void setRestaurant(Restaurant restaurant) { _restaurant = restaurant; }
}
