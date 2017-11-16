package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;

@Entity
@Table(name = "MenuItems")
public class MenuItem extends UniqueItem
{

	@Column(name = "Name")
	private String _name;

	@Column(name = "Description")
	private String _description;

	@Column(name = "Cost")
	private double _cost;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "Type")
	private MenuItemType _type;

	@ManyToOne
	@JoinColumn(name = "MenuKey")
	private Menu _menu;

	public String getName() { return _name; }
	public void setName(String name) { _name = name; }

	public String getDescription() { return _description; }
	public void setDescription(String description) { _description = description; }

	public double getCost() { return _cost; }
	public void setCost(double cost) { _cost = cost; }

	public MenuItemType getType() { return _type; }
	public void setType(MenuItemType type) { _type = type; }

	public Menu getMenu() { return _menu; }
	public void setMenu(Menu menu) { _menu = menu; }
}
