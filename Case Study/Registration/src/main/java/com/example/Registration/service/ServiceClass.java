package com.example.Registration.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Registration.model.User;
import com.example.Registration.model.repo.UserRepository;

@Service
public class ServiceClass implements UserDetailsService 
{
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String emailid) throws UsernameNotFoundException 
	{
		User userExists=repo.findByEmailId(emailid);
		if (userExists==null)
			return null;
		
		String tempEmailid=userExists.getEmailId();
		String tempPssword=userExists.getPassword();
		return new org.springframework.security.core.userdetails.User(tempEmailid, tempPssword, new ArrayList<>());
	}
}