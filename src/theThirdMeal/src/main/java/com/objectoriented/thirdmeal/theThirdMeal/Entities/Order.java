package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Orders")
public class Order extends UserItem implements PersistableEntity
{
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreatedTime", nullable = false)
	private Date createdTime;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "OrderStatus", nullable = false)
	private OrderStatus orderStatus;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> orderItems;

	public Order(){}

	public Order(Date createdTime, OrderStatus orderStatus, List<OrderItem> orderItems)
	{
		this.createdTime = createdTime;
		this.orderStatus = orderStatus;
		this.orderItems = orderItems;
	}

	public Date getCreatedTime() { return this.createdTime; }
	public void setCreatedTime(Date createdTime) { this.createdTime = createdTime; }

	public OrderStatus getOrderStatus() { return this.orderStatus; }
	public void setOrderStatus(OrderStatus orderStatus) { this.orderStatus = orderStatus; }

	public List<OrderItem> getOrderItems() { return this.orderItems; }
	public void setOrderItems(List<OrderItem> orderItems) { this.orderItems = orderItems; }

	public void enforceRelationships()
	{
		if(this.orderItems != null)
		{
			for(OrderItem orderItem : this.orderItems)
			{
				orderItem.setOrder(this);
				orderItem.setUser(this.user);
			}
		}
	}

	public void loadProperties()
	{
		if(this.orderItems != null)
			this.orderItems.size();
	}
}
