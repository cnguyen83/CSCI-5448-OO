package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Menus")
public class Menu extends UniqueItem
{

	@Column(name = "Name")
	private String _name;

	@OneToMany(mappedBy = "_menu")
	private List<MenuItem> _menuItems;

	@ManyToOne
	@JoinColumn(name = "RestaurantKey")
	private Restaurant _restaurant;

	public String getName() { return _name;	}
	public void setName(String name) { _name = name; }

	public List<MenuItem> getMenuItems() { return _menuItems; }
	public void set_menuItems(List<MenuItem> menuItems) { _menuItems = menuItems; }

	public Restaurant getRestaurant() { return _restaurant; }
	public void setRestaurant(Restaurant restaurant) { _restaurant = restaurant; }
}
