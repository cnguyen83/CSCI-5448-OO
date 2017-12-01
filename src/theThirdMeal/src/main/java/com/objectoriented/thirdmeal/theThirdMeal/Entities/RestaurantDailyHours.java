package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.time.DayOfWeek;
import java.util.Date;
import java.util.Locale;

@Entity
@Table(name = "RestaurantDailyHours")
public class RestaurantDailyHours extends UserItem implements Comparable<RestaurantDailyHours>
{
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "DayOfWeek", nullable = false)
	private DayOfWeek dayOfWeek;

	@DateTimeFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "StartTime")
	private Date startTime;

	@DateTimeFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "StopTime")
	private Date stopTime;

	@ManyToOne
	@JoinColumn(name = "RestaurantKey", nullable = false)
	private Restaurant restaurant;

	public RestaurantDailyHours(){}

	public RestaurantDailyHours(DayOfWeek dayOfWeek, Time startTime, Time stopTime)
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

	public String displayDayOfWeek()
	{
		Locale locale = Locale.getDefault();
		return this.dayOfWeek.getDisplayName(TextStyle.SHORT, locale);
	}

	public Boolean isClosed()
	{
		return startTime == null || stopTime == null;
	}

	@Override
	public int compareTo(RestaurantDailyHours o) {
		return this.dayOfWeek.compareTo(o.dayOfWeek);
	}
}
