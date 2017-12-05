package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;

@Entity
@Table(name = "MenuItems")
public class MenuItem extends UserItem
{
	@Column(name = "Name", nullable = false)
	private String name;

	@Column(name = "Description")
	private String description;

	@Column(name = "Cost", nullable = false)
	private Double cost;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "Type")
	private MenuItemType type;

	@ManyToOne
	@JoinColumn(name = "MenuKey", nullable = false)
	private Menu menu;

	public MenuItem(){}

	public MenuItem(String name, String description, Double cost, MenuItemType type)
	{
		this.name = name;
		this.description = description;
		this.cost = cost;
		this.type = type;
	}

	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }

	public String getDescription() { return this.description; }
	public void setDescription(String description) { this.description = description; }

	public Double getCost() { return this.cost; }
	public void setCost(Double cost) { this.cost = cost; }

	public MenuItemType getType() { return this.type; }
	public void setType(MenuItemType type) { this.type = type; }

	public Menu getMenu() { return this.menu; }
	public void setMenu(Menu menu) { this.menu = menu; }
}
