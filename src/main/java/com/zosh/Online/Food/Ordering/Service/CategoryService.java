package com.zosh.Online.Food.Ordering.Service;

import java.util.List;

import com.zosh.Online.Food.Ordering.Model.Category;

public interface CategoryService {

	public Category createCatagory(String name,Long userId) throws Exception;
	
	public List<Category> findCategoryByRestaurantId(Long id) throws Exception;
	
	public Category findCategoryById(Long id) throws Exception;

	
}
