package com.example.Coupons.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Coupons.model.Coupons;

@Repository
public interface CouponsRepository extends MongoRepository<Coupons, String> 
{

	public List<Coupons> findByStoreName(String storeName);

	public List<Coupons> findByCategory(String category);

	public List<Coupons> findBySubcategory(String subcategory);

}
