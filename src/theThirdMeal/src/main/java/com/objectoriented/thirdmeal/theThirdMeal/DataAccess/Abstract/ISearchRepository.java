package com.objectoriented.thirdmeal.theThirdMeal.DataAccess.Abstract;

import java.util.List;

public interface ISearchRepository<T> {

	List<T> search(String searchString);
}
