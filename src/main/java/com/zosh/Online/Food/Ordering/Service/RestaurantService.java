package com.zosh.Online.Food.Ordering.Service;

import java.util.List;

import com.zosh.Online.Food.Ordering.Model.Restaurant;
import com.zosh.Online.Food.Ordering.Model.User;
import com.zosh.Online.Food.Ordering.Request.CreateRestaurantRequest;
import com.zosh.Online.Food.Ordering.dto.RestaurantDto;

public interface RestaurantService {

	public Restaurant createRestaurant(CreateRestaurantRequest req, User user);
public Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest updatedRestaurant) throws Exception;

public void deleteRestaurant(Long restaurantId) throws Exception;

public List<Restaurant> getAllRestaurant();

//public List<Restaurant> searchRestaurant();

public Restaurant findRestaurantById(Long id) throws Exception;

public Restaurant getRestaurantByUserId(Long userId) throws Exception;

public RestaurantDto addToFavorites(Long restaurantId, User user) throws Exception;

public Restaurant updateRestaurantStatus(Long id) throws Exception;
public List<Restaurant> searchRestaurant(String keyword);
}



