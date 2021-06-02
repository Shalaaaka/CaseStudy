package com.example.Stores.controller;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.Stores.model.Coupons;
import com.example.Stores.model.Stores;
import com.example.Stores.service.StoresService;

@RestController  
public class StoresController 
{
	@Autowired
	private StoresService service;
	
	@Autowired
	private RestTemplate restTemplate;
	
	//Create Store
	@PostMapping("/createStores")
	@CrossOrigin(origins="http://localhost:4200")
	public Stores createStore(@Valid @RequestBody Stores stores) throws Exception
	{
		 Stores storesobj=service.saveStore(stores);
		return storesobj;
	}
	
	//Get All Stores
	@GetMapping("/getAllStores")
	@CrossOrigin(origins="http://localhost:4200")
	public Collection<Stores> getAll()
	{
		return service.getAllStores();
	}
	
	//Get Store By Id
	@GetMapping("/getStore/{id}")
	@CrossOrigin(origins="http://localhost:4200")
    public Stores findStore(@PathVariable(value= "id") String id)
	{
		return service.findStore(id);
    }
	
	//Delete Store By Id
	@DeleteMapping("/deleteStore/{id}")
	@CrossOrigin(origins="http://localhost:4200")
    public String deleteStore(@PathVariable(value= "id") String id) 
	{
        service.deleteStore(id);
        return "Store " + id + " deleted.";
    }
	
	//Update Store By Id
	@PutMapping("/updateStore/{id}")
	@CrossOrigin(origins="http://localhost:4200")
    public Stores updateStore(@PathVariable(value= "id") String id,@Valid @RequestBody Stores stores)
	{
		Stores obj=service.findStore(id);
		obj.setName(stores.getName());
		obj.setAvailableOffers(stores.getAvailableOffers());
		obj.setPhoto(stores.getPhoto());
		final Stores updatedStore=service.saveStore(obj);
		return updatedStore;
    }
	
	//Rest Template (Coupons Microservice)
	@GetMapping("/findAllStoresCoupons")
	@CrossOrigin(origins="http://localhost:4200")
	public List<Coupons> findcoupons()
	{
		//final String uri="http://coupons/findAllCoupons"; Eureka client (LoadBalancing Annotation)
		final String uri="http://localhost:8684/findAllCoupons";
		Coupons[] coupons=restTemplate.getForObject(uri, Coupons[].class);
		return Arrays.asList(coupons);
	}
}