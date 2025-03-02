package com.zosh.Online.Food.Ordering.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zosh.Online.Food.Ordering.Model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	public List<Category> findByRestaurantId(Long id);
	
}
