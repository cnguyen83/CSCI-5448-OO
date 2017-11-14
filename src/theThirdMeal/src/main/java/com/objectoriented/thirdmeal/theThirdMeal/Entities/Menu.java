package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Menus")
public class Menu {

	private String _name;

	@Column(name = "Name")
	public String getName() { return _name;	}
	public void setName(String name) { _name = name; }
}
