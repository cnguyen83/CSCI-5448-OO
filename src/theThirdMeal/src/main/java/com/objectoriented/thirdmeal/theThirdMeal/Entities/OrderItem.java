package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;

@Entity
@Table(name = "OrderItems")
public class OrderItem {

	private byte _quantity;

	@Column(name = "Quantity")
	public byte getQuantity() { return _quantity; }
	public void setQuantity(byte quantity) { _quantity = quantity; }
}
