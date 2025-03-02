package com.zosh.Online.Food.Ordering.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zosh.Online.Food.Ordering.Model.Food;
import com.zosh.Online.Food.Ordering.Model.Restaurant;
import com.zosh.Online.Food.Ordering.Model.User;
import com.zosh.Online.Food.Ordering.Request.CreateFoodRequest;
import com.zosh.Online.Food.Ordering.Response.MessageResponse;
import com.zosh.Online.Food.Ordering.Service.FoodService;
import com.zosh.Online.Food.Ordering.Service.RestaurantService;
import com.zosh.Online.Food.Ordering.Service.UserService;

@RestController
@RequestMapping("/api/admin/food")
public class AdminFoodController {

	@Autowired
	private FoodService foodService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping
	public ResponseEntity<Food> createFood(@RequestBody CreateFoodRequest req, @RequestHeader("Authorization") String jwt) throws Exception{
		User user =userService.findUserByJwtToken(jwt);
		Restaurant restaurant=restaurantService.findRestaurantById(req.getRestaurantId());
		Food food=foodService.createFood(req, req.getCategory(), restaurant);
		 return new ResponseEntity<>(food,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<MessageResponse> deleteFood(@PathVariable Long id, 
			@RequestHeader("Authorization") String jwt) 
					throws Exception{
		User user =userService.findUserByJwtToken(jwt);
		
		foodService.deleteFood(id);
		
		MessageResponse res=new MessageResponse();
		res.setMessage("food deleted successfully");
		 return new ResponseEntity<>(res,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Food> updateFoodAvailibilityStatus(@PathVariable Long id, 
			@RequestHeader("Authorization") String jwt) 
					throws Exception{
		User user =userService.findUserByJwtToken(jwt);
		
		Food food=foodService.updateAvailibilityStatus(id);
		
		
		 return new ResponseEntity<>(food,HttpStatus.CREATED);
	}
}
