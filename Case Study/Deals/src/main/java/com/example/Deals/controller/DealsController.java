package com.example.Deals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Deals.model.Deals;
import com.example.Deals.service.DealsService;

@RestController
public class DealsController 
{
	@Autowired
	private DealsService service;
	
	//Create Deal
	@PostMapping("/createDeal")
	@CrossOrigin(origins="http://localhost:4200")
	public Deals createDeal(@RequestBody Deals deals)
	{
		Deals dealsObj=service.saveDeal(deals);
		return dealsObj;
	}
	
	//Find Deal By Id
	@GetMapping("/findDealById/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public Deals findCouponById(@PathVariable(value= "id") String id)
	{
		Deals deal=service.findDealById(id);
		return deal;
	}
	
	//Find Deal By StoreName
	@GetMapping("/findDealsByStoreName/{storeName}")
	@CrossOrigin(origins="http://localhost:4200")
	public List<Deals> findDealsByStoreName(@PathVariable(value="storeName") String storeName)
	{
		return service.findDealsByStore(storeName);
	}
	
	//Find Deals ByCategory
	@GetMapping("/findDealsByCategory/{category}")
	@CrossOrigin(origins="http://localhost:4200")
	public List<Deals> findDealsByCategory(@PathVariable(value="category") String category)
	{
		return service.findDealsByCategory(category);
	}
	
	//Find All Deals
	@GetMapping("/findAllDeals")
	@CrossOrigin(origins="http://localhost:4200")
	public List<Deals> findAllDeals()
	{
		return service.findAllDeals();
	}
	
	//Delete Deal By Id
	@DeleteMapping("/deleteDealById/{id}")
	@CrossOrigin(origins="http://localhost:4200")
    public String delete(@PathVariable(value= "id") String id) 
    {	
       service.deleteDealsById(id);
        return "Store " + id + " deleted.";
    }
	
	//Update Deal By Id
	@PutMapping("/updateDealById/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public Deals updateDeals(@PathVariable(value= "id") String id,@RequestBody Deals deals)
	{
		Deals obj=service.findDealById(id);
		obj.setStoreName(deals.getStoreName());
		obj.setStorePhotoUrl(deals.getStorePhotoUrl());
		obj.setOffPercentage(deals.getOffPercentage());
		obj.setDescription(deals.getDescription());
		obj.setCategory(deals.getCategory());
		obj.setSubcategory(deals.getSubcategory());
		obj.setDate(deals.getDate());
		obj.setTime(deals.getTime());
		obj.setDealCode(deals.getDealCode());
		obj.setDealLink(deals.getDealLink());
		final Deals updatedDeal=service.saveDeal(obj);
		return updatedDeal;
	}
}
