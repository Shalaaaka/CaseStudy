package com.example.Deals.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Deals.model.Deals;
import com.example.Deals.model.repository.DealsRepository;

@Service
public class DealsService 
{
	@Autowired
	private DealsRepository repo;
	
	//Save Deal
	public Deals saveDeal(Deals deals)
	{
		return repo.save(deals);
	}
		
	//Find Deal by Store Name
	public List<Deals> findDealsByStore(String storeName)
	{
		return repo.findByStoreName(storeName);
	}
		
	//Find Deal by Category
	public List<Deals> findDealsByCategory(String category)
	{
		return repo.findByCategory(category);
	}
		
	//Find All Deals
	public List<Deals> findAllDeals()
	{
		return repo.findAll();
	}
	
	//Delete Deal by Id
	public void deleteDealsById(String id)
	{
		repo.deleteById(id);
	}
	
	//Find Deal By Id
	public Deals findDealById(String id) 
	{
		return repo.findById(id).get();
	}

}
