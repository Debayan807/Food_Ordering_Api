package com.zosh.Online.Food.Ordering.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zosh.Online.Food.Ordering.Model.Restaurant;
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long>{

	
	@Query("SELECT r FROM Restaurant r WHERE lower(r.name) LIKE lower(concat('%',:query, '%')) OR lower(r.cuisineType) LIKE lower(concat('%', :query, '%'))")
	List<Restaurant> findBySearchQuery(String query);
	Restaurant findByOwnerId(Long userId);
}
