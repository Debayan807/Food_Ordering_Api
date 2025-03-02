package com.zosh.Online.Food.Ordering.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zosh.Online.Food.Ordering.Config.JwtProvider;
import com.zosh.Online.Food.Ordering.Model.User;
import com.zosh.Online.Food.Ordering.Repository.UserRepository;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@Override
	public User findUserByJwtToken(String jwt) throws Exception {
		// TODO Auto-generated method stub
	String email=jwtProvider.getEmailFromJwtToken(jwt);
	User user = findUserByEmail(email);
	return user;
	}

	@Override
	public User findUserByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		User user =userRepository.findByEmail(email);
		
		if(user==null) {
			throw new Exception("user not found");
		}
		return user;
	}

	
}
