package com.example.Stores.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Stores.model.Stores;
import com.example.Stores.repository.StoersRepository;

@Service
public class StoresService
{
	@Autowired
	private StoersRepository repo;
	
	//Save Store
	public Stores saveStore(Stores stores)
	{
		return repo.save(stores);
	}
	
	//Find All Stores
	public List<Stores> getAllStores()
	{
		return repo.findAll();
	}
	
	//Find store
	public Stores findStore(String id)
	{
		return repo.findById(id).get();
	}
	
	//Delete Store
	public void deleteStore(String id) 
	{
		repo.deleteById(id);
	}
}
