package com.objectoriented.thirdmeal.theThirdMeal.Entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class UniqueItem
{
	@Id
	@GeneratedValue
	@Column(name = "EntityKey", nullable = false)
	protected Long key;

	public Long getKey() { return this.key; }
	public void setKey(Long key) { this.key = key; }
}
