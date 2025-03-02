package com.zosh.Online.Food.Ordering.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zosh.Online.Food.Ordering.Model.IngredientCategory;
import com.zosh.Online.Food.Ordering.Model.IngredientsItem;
import com.zosh.Online.Food.Ordering.Model.Restaurant;
import com.zosh.Online.Food.Ordering.Repository.IngredientCategoryRepository;
import com.zosh.Online.Food.Ordering.Repository.IngredientItemRepository;

@Service
public class IngredientServiceImp implements IngredientsService{

	@Autowired
	private IngredientItemRepository ingredientItemRepository;
	
	@Autowired
	private IngredientCategoryRepository ingredientCategoryRepository;
	
	@Autowired
	private RestaurantService restaurantService;

	@Override
	public IngredientCategory createIngredientCategory(String name, Long restaurantId) throws Exception {
		// TODO Auto-generated method stub
		Restaurant restaurant=restaurantService.findRestaurantById(restaurantId);
		IngredientCategory category=new IngredientCategory();
		category.setRestaurant(restaurant);
		category.setName(name);
		return ingredientCategoryRepository.save(category);
	}

	@Override
	public IngredientCategory findIngredientCategoryById(Long id) throws Exception {
		// TODO Auto-generated method stub
		Optional<IngredientCategory> opt=ingredientCategoryRepository.findById(id);
		
		if(opt.isEmpty()) {
			throw new Exception("ingredient category not found");
		}
		return opt.get();
	}

	@Override
	public List<IngredientCategory> findIngredientCategoryByRestaurantId(Long id) throws Exception {
		// TODO Auto-generated method stub
		restaurantService.findRestaurantById(id);
		return ingredientCategoryRepository.findByRestaurantId(id);
	}

	@Override
	public IngredientsItem createIngredientItem(Long restaurantId, String ingredientName, Long categoryId)
			throws Exception {
		// TODO Auto-generated method stub
		Restaurant restaurant=restaurantService.findRestaurantById(restaurantId);
		IngredientCategory category=findIngredientCategoryById(categoryId);
		
		IngredientsItem item=new IngredientsItem();
		item.setName(ingredientName);
		item.setRestaurant(restaurant);
		item.setCategory(category);
		
		IngredientsItem ingredient = ingredientItemRepository.save(item);
		category.getIngredients().add(ingredient);
		
		
		return ingredient;
	}

	@Override
	public List<IngredientsItem> findRestaurantsIngredients(Long restaurantId) {
		// TODO Auto-generated method stub
		return ingredientItemRepository.findByRestaurantId(restaurantId);
	}

	@Override
	public IngredientsItem updateStock(Long id) throws Exception {
		// TODO Auto-generated method stub
		Optional<IngredientsItem> optionalIngredientsItem=ingredientItemRepository.findById(id);
		
		if(optionalIngredientsItem.isEmpty()) {
			throw new Exception("ingredient not found");
		}
		
		IngredientsItem ingredientsItem=optionalIngredientsItem.get();
		ingredientsItem.setStoke(!ingredientsItem.isStoke());
		return ingredientItemRepository.save(ingredientsItem);
	}
}
