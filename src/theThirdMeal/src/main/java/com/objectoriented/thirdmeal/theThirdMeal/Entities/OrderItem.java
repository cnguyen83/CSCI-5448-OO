package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;

@Entity
@Table(name = "OrderItems")
public class OrderItem extends UserItem
{
	@Column(name = "Quantity", nullable = false)
	private Integer _quantity;

	@ManyToOne
	@JoinColumn(name = "OrderKey", nullable = false)
	private Order _order;

	public OrderItem(){}

	public OrderItem(Integer quantity, Order order)
	{
		_quantity = quantity;
		_order = order;
	}

	public Integer getQuantity() { return _quantity; }
	public void setQuantity(Integer quantity) { _quantity = quantity; }

	public Order getOrder() { return _order; }
	public void setOrder(Order order) { _order = order;	}
}
