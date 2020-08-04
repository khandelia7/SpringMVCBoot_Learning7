package com.telusko.secureapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.telusko.secureapp.model.User;
import com.telusko.secureapp.repository.UserRepository;

@Service
public class MyUserDetailsSevice implements UserDetailsService{
	
	@Autowired
 	private UserRepository userrepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userrepository.findByUsername(username);
 		if(user==null)
 			throw new UsernameNotFoundException("User 404");
 		return new UserPrincipal(user);
	}
}
