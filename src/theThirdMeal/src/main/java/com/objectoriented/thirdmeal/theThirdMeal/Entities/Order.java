package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Orders")
public class Order extends UserItem
{
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreatedTime", nullable = false)
	private Date _createdTime;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "OrderStatus", nullable = false)
	private OrderStatus _orderStatus;

	@OneToMany(mappedBy = "_order", cascade = CascadeType.ALL)
	private List<OrderItem> _orderItems;

	public Order(){}

	public Order(Date createdTime, OrderStatus orderStatus, List<OrderItem> orderItems)
	{
		_createdTime = createdTime;
		_orderStatus = orderStatus;
		_orderItems = orderItems;
	}

	public Date getCreatedTime() { return _createdTime; }
	public void setCreatedTime(Date createdTime) { _createdTime = createdTime; }

	public OrderStatus getOrderStatus() { return _orderStatus; }
	public void setOrderStatus(OrderStatus orderStatus) { _orderStatus = orderStatus; }

	public List<OrderItem> getOrderItems() { return _orderItems; }
	public void setOrderItems(List<OrderItem> orderItems) { _orderItems = orderItems; }

	public void loadProperties()
	{
		if(_orderItems != null)
			_orderItems.size();
	}
}
