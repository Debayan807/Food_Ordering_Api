package com.zosh.Online.Food.Ordering.Request;

import org.springframework.stereotype.Component;

import com.zosh.Online.Food.Ordering.Model.Address;

import lombok.Data;

@Data
@Component
public class OrderRequest {

	private Long restaurantId;
	private Address deliveryAddress;
	public Long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	public Address getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	
	
}
