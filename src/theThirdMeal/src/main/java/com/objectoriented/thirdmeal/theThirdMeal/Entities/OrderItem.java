package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;

@Entity
@Table(name = "OrderItems")
public class OrderItem extends UniqueItem
{

	@Column(name = "Quantity")
	private int _quantity;

	@ManyToOne
	@JoinColumn(name = "OrderKey")
	private Order _order;

	public int getQuantity() { return _quantity; }
	public void setQuantity(int quantity) { _quantity = quantity; }

	public Order getOrder() { return _order; }
	public void setOrder(Order order) { _order = order;	}
}
