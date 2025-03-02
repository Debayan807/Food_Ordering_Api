package com.zosh.Online.Food.Ordering.Service;

import com.zosh.Online.Food.Ordering.Model.User;

public interface UserService {

	public User findUserByJwtToken(String jwt) throws Exception;
	
	public User findUserByEmail(String email) throws Exception;
}
