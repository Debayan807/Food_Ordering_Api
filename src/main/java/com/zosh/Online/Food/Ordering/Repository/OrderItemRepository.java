package com.zosh.Online.Food.Ordering.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zosh.Online.Food.Ordering.Model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

	
}
