package com.example.Authentication.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.Authentication.jwt.JwtClass;
import com.example.Authentication.service.ServiceClass;

@Component
public class JwtFilter extends OncePerRequestFilter 
{
	@Autowired
	private ServiceClass uds;
	
	@Autowired
	private JwtClass jwt;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException 
	{
		String tokenHeader=request.getHeader("Authorization");
		String emailId=null;
		String jwtToken=null;
		if (tokenHeader!=null && tokenHeader.startsWith("Bearer "))
		{
			jwtToken=tokenHeader.substring(7);
			try 
			{
				emailId=this.jwt.extractUsername(jwtToken);
				
			} catch (Exception e) 
			{
				// TODO: handle exception
			}
			
			UserDetails ud=this.uds.loadUserByUsername(emailId);
			if (emailId!=null && SecurityContextHolder.getContext().getAuthentication()==null)
			{
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(ud, null,ud.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
			else
			{
				System.out.println("invalid token");
	
			}
		}
		filterChain.doFilter(request, response);
		
	}

}
