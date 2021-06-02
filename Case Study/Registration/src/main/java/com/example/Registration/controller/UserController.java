package com.example.Registration.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Registration.exception.UserAlreadyExistsException;
import com.example.Registration.jwthelper.JwtClass;
import com.example.Registration.model.AuthRequest;
import com.example.Registration.model.Response;
import com.example.Registration.model.User;
import com.example.Registration.service.ServiceClass;
import com.example.Registration.service.UserService;


@RestController  
@RequestMapping
public class UserController 
{
	@Autowired
	private ServiceClass userDetailsService;
	
	@Autowired
	private JwtClass jwt;
	
	@Autowired
	private UserService service;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/auth")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<?> generateToken(@RequestBody AuthRequest authRequest) throws Exception
	{
		try
		{
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmailId(), authRequest.getPassword()));
		}
		catch (Exception e)
		{
			throw new Exception("Login Error");
		}
		UserDetails ud=this.userDetailsService.loadUserByUsername(authRequest.getEmailId());
		String token=this.jwt.generateToken(ud);
		
		return ResponseEntity.ok(new Response(token));
		
	}
	
	@GetMapping("/access")
	@CrossOrigin(origins="http://localhost:4200")
	private User getLoggedInUser(Principal principal)
	{
		return service.fetchUserByEmailId(principal.getName());
	}
	
	@PostMapping("/register")
	@CrossOrigin(origins="http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception
	{
		String tempEmailId=user.getEmailId();
		if (tempEmailId!=null && !"".equals(tempEmailId))
		{
			User userobj=service.fetchUserByEmailId(tempEmailId);//find if user of that emailid is present 
			if (userobj!=null)
			{
				throw new UserAlreadyExistsException();
			}
		}
		
		User userobj=null;
		userobj=service.saveUser(user);
		return userobj;
	}
	
	
	@PostMapping("/loginuser")
	@CrossOrigin(origins="http://localhost:4200")
	public User loginMethod(@RequestBody User user) throws Exception
	{
		String tempEmailId=user.getEmailId();
		String tempPass=user.getPassword();
		User userobj=null;
		if (tempEmailId!=null && tempPass!=null)
		{
			userobj=service.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
		}
		if(userobj==null)
		{
			throw new Exception("Bad Credentials");
		}
		return userobj;
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins="http://localhost:4200")
	private ResponseEntity<?> loginUser(@RequestBody User user)
	{
		String tempEmailId=user.getEmailId();
		String tempPass=user.getPassword();
		try
		{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(tempEmailId, tempPass));
		}
		catch (Exception e)
		{
			return ResponseEntity.ok(new Response("Login Error"));
		}
		return ResponseEntity.ok(new Response("login Successful"));
	}
}