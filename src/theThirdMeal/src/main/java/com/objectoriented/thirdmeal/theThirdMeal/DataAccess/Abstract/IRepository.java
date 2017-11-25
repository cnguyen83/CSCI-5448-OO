package com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract;

public interface IRepository<PersistableEntity> {

	boolean save(PersistableEntity object);

	PersistableEntity read(Long entityKey);

	boolean delete(PersistableEntity object);
}
