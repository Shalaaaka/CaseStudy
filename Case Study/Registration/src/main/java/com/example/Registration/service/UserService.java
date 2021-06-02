package com.example.Registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Registration.model.User;
import com.example.Registration.model.repo.UserRepository;

@Service
public class UserService
{
	@Autowired
	private UserRepository repo;
	
	//save user in DB
	public User saveUser(User user)
	{
		return repo.save(user);
	}
	
	public User fetchUserByEmailId(String email)
	{
		return repo.findByEmailId(email);
	}
	
	public User fetchUserByEmailIdAndPassword(String email,String password)
	{
		return repo.findByEmailIdAndPassword(email,password);
	}
}