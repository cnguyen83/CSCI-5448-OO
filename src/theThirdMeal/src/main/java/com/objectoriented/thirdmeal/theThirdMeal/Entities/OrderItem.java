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

	@ManyToOne
	@JoinColumn(name = "MenuItemKey", nullable = false)
	private MenuItem menuItem;

	public OrderItem(){}

	public OrderItem(Integer quantity, MenuItem menuItem, Order order)
	{
		this.quantity = quantity;
		this.menuItem = menuItem;
		this.order = order;
	}

	public Integer getQuantity() { return this.quantity; }
	public void setQuantity(Integer quantity) { this.quantity = quantity; }

	public MenuItem getMenuItem() { return menuItem; }
	public void setMenuItem(MenuItem menuItem) { this.menuItem = menuItem; }

	public Order getOrder() { return this.order; }
	public void setOrder(Order order) { this.order = order;	}

	public Double calculateCost()
	{
		return quantity * menuItem.getCost();
	}
}
