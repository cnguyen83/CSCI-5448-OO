package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Menus")
public class Menu extends UserItem
{
	@Column(name = "Name", nullable = false)
	private String _name;

	@OneToMany(mappedBy = "_menu", cascade = CascadeType.ALL)
	private List<MenuItem> _menuItems;

	@ManyToOne
	@JoinColumn(name = "RestaurantKey", nullable = false)
	private Restaurant _restaurant;

	public Menu(){}

	public Menu(String name, List<MenuItem> menuItems)
	{
		_name = name;
		_menuItems = menuItems;
	}

	public String getName() { return _name;	}
	public void setName(String name) { _name = name; }

	public List<MenuItem> getMenuItems() { return _menuItems; }
	public void set_menuItems(List<MenuItem> menuItems) { _menuItems = menuItems; }

	public Restaurant getRestaurant() { return _restaurant; }
	public void setRestaurant(Restaurant restaurant) { _restaurant = restaurant; }

	public void loadProperties()
	{
		if(_menuItems != null)
			_menuItems.size();
	}
}
