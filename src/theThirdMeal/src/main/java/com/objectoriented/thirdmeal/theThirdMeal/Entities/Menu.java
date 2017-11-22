package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Menus")
public class Menu extends UserItem
{
	@Column(name = "Name", nullable = false)
	private String name;

	@OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
	private List<MenuItem> menuItems;

	@ManyToOne
	@JoinColumn(name = "RestaurantKey", nullable = false)
	private Restaurant restaurant;

	public Menu(){}

	public Menu(String name, List<MenuItem> menuItems)
	{
		this.name = name;
		this.menuItems = menuItems;
	}

	public String getName() { return this.name;	}
	public void setName(String name) { this.name = name; }

	public List<MenuItem> getMenuItems() { return this.menuItems; }
	public void setMenuItems(List<MenuItem> menuItems) { this.menuItems = menuItems; }

	public Restaurant getRestaurant() { return this.restaurant; }
	public void setRestaurant(Restaurant restaurant) { this.restaurant = restaurant; }

	public void enforceRelationships()
	{
		if(this.menuItems != null)
		{
			for(MenuItem menuItem : this.menuItems)
			{
				menuItem.setMenu(this);
				menuItem.setUser(this.user);
			}
		}
	}

	public void loadProperties()
	{
		if(this.menuItems != null)
			this.menuItems.size();
	}
}
