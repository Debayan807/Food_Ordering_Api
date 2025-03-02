package com.zosh.Online.Food.Ordering.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zosh.Online.Food.Ordering.Model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public User findByEmail(String username);
}
