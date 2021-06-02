package com.example.Coupons.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Coupons.model.Coupons;
import com.example.Coupons.repository.CouponsRepository;

@Service
public class CouponsService 
{
	@Autowired
	private CouponsRepository repo;
	
	//Save Coupon
	public Coupons saveCoupon(Coupons coupon)
	{
		return repo.save(coupon);
	}
	
	//Find Coupon by Store Name
	public List<Coupons> findCouponByStore(String storeName)
	{
		return repo.findByStoreName(storeName);
	}
	
	//Find Coupon by Category
	public List<Coupons> findCouponByCategory(String category)
	{
		return repo.findByCategory(category);
	}
	
	//Find Coupon by Sub category
	public List<Coupons> findCouponBySubcategory(String subcategory)
	{
		return repo.findBySubcategory(subcategory);
	}
	
	//Find all Coupons
	public List<Coupons> findAllCoupons()
	{
		return repo.findAll();
	}
	
	//Delete Coupon by Id
	public void deleteCouponById(String id)
	{
		repo.deleteById(id);
	}

	public Coupons findCouponById(String id) 
	{
		return repo.findById(id).get();
	}
}
