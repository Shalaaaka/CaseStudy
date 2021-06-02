package com.example.Authentication.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

@Service
public class ServiceClass implements UserDetailsService
{

	@Override
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException
	{
		if(emailId.equals("shalaka@gmail.com"))
		{
			return new User("shalaka@gmail.com", "admin", new ArrayList<>());
		}
		else
		{
			throw new UsernameNotFoundException("Not found");
		}
		
	}
	
}
