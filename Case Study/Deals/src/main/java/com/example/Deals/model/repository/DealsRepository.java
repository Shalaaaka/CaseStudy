package com.example.Deals.model.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Deals.model.Deals;

@Repository
public interface DealsRepository extends MongoRepository<Deals, String> 
{

	public List<Deals> findByStoreName(String storeName);

	public List<Deals> findByCategory(String category);

	public List<Deals> findBySubcategory(String subcategory);

}
