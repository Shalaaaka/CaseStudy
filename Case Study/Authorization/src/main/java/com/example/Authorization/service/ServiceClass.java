package com.example.Authorization.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.Authorization.model.User;
import com.example.Authorization.repo.UserRepo;


public class ServiceClass implements UserDetailsService
{
	@Autowired
	private UserRepo repo;


	@Override
	public UserDetails loadUserByUsername(String emailid) throws UsernameNotFoundException 
	{
		Optional<User> user=repo.findByEmailId(emailid);
		return user.map(GroupUserDetails::new).
				orElseThrow(()->new UsernameNotFoundException("User not Exists"));
	}
}
