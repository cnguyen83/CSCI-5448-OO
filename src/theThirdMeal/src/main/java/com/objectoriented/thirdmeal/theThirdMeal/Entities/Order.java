package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Orders")
public class Order {

	private Date _createdTime;
	private OrderStatus _orderStatus;

	@Column(name = "CreatedTime")
	public Date getCreatedTime() { return _createdTime; }
	public void setCreatedTime(Date createdTime) { _createdTime = createdTime; }

	@Column(name = "OrderStatus")
	public OrderStatus getOrderStatus() { return _orderStatus; }
	public void setOrderStatus(OrderStatus orderStatus) { _orderStatus = orderStatus; }
}
