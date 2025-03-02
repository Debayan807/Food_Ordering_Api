package com.zosh.Online.Food.Ordering.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zosh.Online.Food.Ordering.Model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

	public Cart findByCustomerId(Long userId);
}
