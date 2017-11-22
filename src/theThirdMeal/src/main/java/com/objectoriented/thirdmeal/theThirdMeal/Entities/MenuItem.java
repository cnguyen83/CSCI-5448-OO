package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;

@Entity
@Table(name = "MenuItems")
public class MenuItem extends UserItem
{
	@Column(name = "Name", nullable = false)
	private String _name;

	@Column(name = "Description")
	private String _description;

	@Column(name = "Cost", nullable = false)
	private Double _cost;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "Type", nullable = false)
	private MenuItemType _type;

	@ManyToOne
	@JoinColumn(name = "MenuKey", nullable = false)
	private Menu _menu;

	public MenuItem(){}

	public MenuItem(String name, String description, Double cost, MenuItemType type)
	{
		_name = name;
		_description = description;
		_cost = cost;
		_type = type;
	}

	public String getName() { return _name; }
	public void setName(String name) { _name = name; }

	public String getDescription() { return _description; }
	public void setDescription(String description) { _description = description; }

	public Double getCost() { return _cost; }
	public void setCost(Double cost) { _cost = cost; }

	public MenuItemType getType() { return _type; }
	public void setType(MenuItemType type) { _type = type; }

	public Menu getMenu() { return _menu; }
	public void setMenu(Menu menu) { _menu = menu; }
}
