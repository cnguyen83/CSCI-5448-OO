package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Orders")
public class Order extends UserItem
{

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreatedTime")
	private Date _createdTime;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "OrderStatus")
	private OrderStatus _orderStatus;

	@OneToMany(mappedBy = "_order", cascade = CascadeType.ALL)
	private List<OrderItem> _orderItems;

	public Date getCreatedTime() { return _createdTime; }
	public void setCreatedTime(Date createdTime) { _createdTime = createdTime; }

	public OrderStatus getOrderStatus() { return _orderStatus; }
	public void setOrderStatus(OrderStatus orderStatus) { _orderStatus = orderStatus; }

	public List<OrderItem> getOrderItems() { return _orderItems; }
	public void setOrderItems(List<OrderItem> orderItems) { _orderItems = orderItems; }
}
