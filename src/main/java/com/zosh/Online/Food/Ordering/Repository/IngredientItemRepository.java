package com.zosh.Online.Food.Ordering.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zosh.Online.Food.Ordering.Model.IngredientsItem;

public interface IngredientItemRepository extends JpaRepository<IngredientsItem, Long>{

	List<IngredientsItem> findByRestaurantId(Long id);
}
