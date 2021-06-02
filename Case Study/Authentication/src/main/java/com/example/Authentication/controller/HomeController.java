package com.example.Authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Authentication.jwt.JwtClass;
import com.example.Authentication.model.AuthRequest;
import com.example.Authentication.model.Response;
import com.example.Authentication.service.ServiceClass;

@RestController
public class HomeController 
{
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private ServiceClass userDetailsService;
	
	@Autowired
	private JwtClass jwt;
	
	@PostMapping("/token")
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
	
	@GetMapping("/getdata")
	@CrossOrigin(origins="http://localhost:4200")
	public String getData()
	{
		return "{\"name\":\"Shalaka\"}";
	}
	
	
}
