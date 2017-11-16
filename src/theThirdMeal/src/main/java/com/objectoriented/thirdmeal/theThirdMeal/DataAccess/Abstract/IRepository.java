package com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract;

public interface IRepository<T> {

	boolean create(T object);

	T read(Long entityKey);

	boolean update(T object);

	boolean delete(T object);
}
