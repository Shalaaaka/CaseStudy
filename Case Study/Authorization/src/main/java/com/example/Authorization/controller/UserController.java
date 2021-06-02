package com.example.Authorization.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Authorization.model.User;
import com.example.Authorization.repo.UserRepo;

@RestController
public class UserController 
{
	public static final String DEFAULT_ROLE="ROLE_USER";
	@Autowired
	private UserRepo repo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder ;
	
	@PostMapping("/add")
	public String joinGroup(@RequestBody User user)
	{
		user.setRole(DEFAULT_ROLE);
		String encryptespwd=passwordEncoder.encode(user.getPassword());
		user.setPassword(encryptespwd);
		repo.save(user);
		return "Hi "+user.getFname();
	}
	
	@GetMapping("/access/{role}")
	public String giveAccess(@PathVariable String role)
	{
		
	}
	
	private User getLoggedInUser(Principal principal)
	{
		return repo.findByEmailId(principal.getName()).get();
	}
}
