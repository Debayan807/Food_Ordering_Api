package com.zosh.Online.Food.Ordering.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zosh.Online.Food.Ordering.Model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{

}
