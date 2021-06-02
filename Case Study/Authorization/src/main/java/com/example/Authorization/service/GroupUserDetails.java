package com.example.Authorization.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.Authorization.model.User;

public class GroupUserDetails implements UserDetails
{
	private String fname;
	private String lname;
	private String emailId;
	private String mobile;
	private String password;
	private List<GrantedAuthority> authorities;
	
	public GroupUserDetails(User user)
	{
		this.fname=user.getFname();
		this.lname=user.getLname();
		this.emailId=user.getEmailId();
		this.mobile=user.getMobile();
		this.password=user.getPassword();
		this.authorities=Arrays.stream(user.getRole().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		return authorities;
	}

	@Override
	public String getPassword() 
	{
		return password;
	}

	@Override
	public String getUsername() 
	{
		return emailId;
	}

	@Override
	public boolean isAccountNonExpired() 
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked() 
	{
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() 
	{
		return true;
	}

	@Override
	public boolean isEnabled() 
	{
		return true;
	}

}
