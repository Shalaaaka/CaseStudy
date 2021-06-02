package com.example.OffersCashback.controller;

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

import com.example.OffersCashback.model.Cashback;
import com.example.OffersCashback.service.CashbackService;

@RestController
public class CashbackController 
{
	@Autowired
	private CashbackService service;
	
	@PostMapping("/create")
	@CrossOrigin(origins="http://localhost:4200")
	public Cashback createCashback(@RequestBody Cashback cashback)
	{
		Cashback dealsObj=service.saveCashback(cashback);
		return dealsObj;
	}
	
	@GetMapping("/findById/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public Cashback findCashbackById(@PathVariable(value= "id") String id)
	{
		Cashback cashback=service.findCashbackById(id);
		return cashback;
	}
	
	@GetMapping("/findAll")
	@CrossOrigin(origins="http://localhost:4200")
	public List<Cashback> findAllCashback()
	{
		return service.findAllCashback();
	}
	
	@DeleteMapping("/deleteById/{id}")
	@CrossOrigin(origins="http://localhost:4200")
    public String delete(@PathVariable(value= "id") String id) 
    {	
       service.deleteCashbackById(id);
        return "Store " + id + " deleted.";
    }
	
	@PutMapping("/updateById/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public Cashback updateCashback(@PathVariable(value= "id") String id,@RequestBody Cashback deals)
	{
		Cashback obj=service.findCashbackById(id);
		obj.setStoreName(deals.getStoreName());
		obj.setStorePhotoUrl(deals.getStorePhotoUrl());
		obj.setOffPercentage(deals.getOffPercentage());
		obj.setDescription(deals.getDescription());
		obj.setCategory(deals.getCategory());
		obj.setSubcategory(deals.getSubcategory());
		obj.setDate(deals.getDate());
		obj.setTime(deals.getTime());
		obj.setCode(deals.getCode());
		obj.setLink(deals.getLink());
		final Cashback updatedDeal=service.saveCashback(obj);
		return updatedDeal;
	}
}
