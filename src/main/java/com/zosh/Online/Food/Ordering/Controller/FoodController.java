package com.zosh.Online.Food.Ordering.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zosh.Online.Food.Ordering.Model.Food;
import com.zosh.Online.Food.Ordering.Model.Restaurant;
import com.zosh.Online.Food.Ordering.Model.User;
import com.zosh.Online.Food.Ordering.Request.CreateFoodRequest;
import com.zosh.Online.Food.Ordering.Service.FoodService;
import com.zosh.Online.Food.Ordering.Service.RestaurantService;
import com.zosh.Online.Food.Ordering.Service.UserService;

@RestController
@RequestMapping("/api")
public class FoodController {

	@Autowired
	private FoodService foodService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping("/search")
	public ResponseEntity<List<Food>> searchFood(@RequestParam String name, @RequestHeader("Authorization") String jwt) throws Exception{
		User user =userService.findUserByJwtToken(jwt);
		
		List<Food> food=foodService.searchFood(name);
		 return new ResponseEntity<>(food,HttpStatus.CREATED);
	}
	
	@GetMapping("/restaurant/{restaurantId}")
	public ResponseEntity<List<Food>> getRestaurantFood(
			@RequestParam boolean vagetarian,
			@RequestParam boolean seasonal,
			@RequestParam boolean nonveg,
			@RequestParam(required = false) String food_category,
			@PathVariable Long restaurantId,
			@RequestHeader("Authorization") String jwt) throws Exception{
		User user =userService.findUserByJwtToken(jwt);
		
		List<Food> food=foodService.getRestaurantsFood(restaurantId, vagetarian, nonveg, seasonal, food_category);
		 return new ResponseEntity<>(food,HttpStatus.OK);
	}
}
