package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;
import java.sql.Time;
import java.time.DayOfWeek;

@Entity
@Table(name = "RestaurantDailyHours")
public class RestaurantDailyHours {

	private DayOfWeek _dayOfWeek;
	private Time _startTime;
	private Time _stopTime;

	@Column(name = "DayOfWeek")
	public DayOfWeek getDayOfWeek() { return _dayOfWeek; }
	public void setDayOfWeek(DayOfWeek dayOfWeek) { _dayOfWeek = dayOfWeek; }

	@Column(name = "StartTime")
	public Time getStartTime() { return _startTime; }
	public void setStartTime(Time startTime) { _startTime = startTime; }

	@Column(name = "StartTime")
	public Time getStopTime() { return _stopTime; }
	public void setStopTime(Time stopTime) { _stopTime = stopTime; }
}
