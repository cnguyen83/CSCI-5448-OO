package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;

@Entity
@Table(name = "MenuItems")
public class MenuItem {

	private String _name;
	private String _description;
	private double _cost;
	private MenuItemType _type;

	@Column(name = "Name")
	public String getName() { return _name; }
	public void setName(String name) { _name = name; }

	@Column(name = "Description")
	public String getDescription() { return _description; }
	public void setDescription(String description) { _description = description; }

	@Column(name = "Cost")
	public double getCost() { return _cost; }
	public void setCost(double cost) { _cost = cost; }

	@Column(name = "Type")
	public MenuItemType getType() { return _type; }
	public void setType(MenuItemType type) { _type = type; }
}
