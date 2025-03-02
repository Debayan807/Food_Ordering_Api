package com.zosh.Online.Food.Ordering.Service;

import java.util.List;

import com.zosh.Online.Food.Ordering.Request.OrderRequest;

import com.zosh.Online.Food.Ordering.Model.Order;
import com.zosh.Online.Food.Ordering.Model.User;


public interface OrderService {

	public Order createOrder(OrderRequest order,User user) throws Exception;
	
	public Order updateOrder(Long orderId, String orderStatus)throws Exception;
	
	public void cancelOrder(Long orderId)throws Exception;
	
	public List<Order> getUsesOrder(Long userId)throws Exception;
	
	public List<Order> getRestaurantsOrder(Long restaurantId,String orderStatus)throws Exception;

	public Order findOrderById(Long orderId) throws Exception;
	
	
}
