package com.zosh.Online.Food.Ordering.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zosh.Online.Food.Ordering.Model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

	public List<Order> findByCustomerId(Long userId);
	public List<Order> findByRestaurantId(Long restaurantId);
}
