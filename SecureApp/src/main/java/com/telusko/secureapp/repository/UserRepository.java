package com.telusko.secureapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.secureapp.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
