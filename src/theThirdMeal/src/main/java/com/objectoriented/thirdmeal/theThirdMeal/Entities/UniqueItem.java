package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class UniqueItem
{

	@Id
	@GeneratedValue
	@Column(name = "EntityKey")
	private Long _key;

	public Long getKey() { return _key; }
	public void setKey(Long key) { _key = key; }
}
