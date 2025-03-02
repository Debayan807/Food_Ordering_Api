package com.zosh.Online.Food.Ordering.Service;

import java.util.List;

import com.zosh.Online.Food.Ordering.Model.Category;
import com.zosh.Online.Food.Ordering.Model.Food;
import com.zosh.Online.Food.Ordering.Model.Restaurant;
import com.zosh.Online.Food.Ordering.Request.CreateFoodRequest;

public interface FoodService {

	public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant); 
		
		void deleteFood(Long foodId) throws Exception;
		
		public List<Food> getRestaurantsFood(Long restaurantId, boolean isVegitarain, boolean isNonveg,boolean isSeasonal,String foodCategory );
		
		public List<Food> searchFood(String keyword);
		public Food findFoodById(Long foodId) throws Exception;
		public Food updateAvailibilityStatus(Long foodId) throws Exception;
}
