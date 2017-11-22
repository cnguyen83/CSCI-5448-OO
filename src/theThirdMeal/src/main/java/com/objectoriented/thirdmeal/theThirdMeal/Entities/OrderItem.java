package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;

@Entity
@Table(name = "OrderItems")
public class OrderItem extends UserItem
{
	@Column(name = "Quantity", nullable = false)
	private Integer quantity;

	@ManyToOne
	@JoinColumn(name = "OrderKey", nullable = false)
	private Order order;

	public OrderItem(){}

	public OrderItem(Integer quantity, Order order)
	{
		this.quantity = quantity;
		this.order = order;
	}

	public Integer getQuantity() { return this.quantity; }
	public void setQuantity(Integer quantity) { this.quantity = quantity; }

	public Order getOrder() { return this.order; }
	public void setOrder(Order order) { this.order = order;	}
}
