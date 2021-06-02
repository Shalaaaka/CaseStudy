package com.example.OffersCashback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OffersCashback.model.Cashback;
import com.example.OffersCashback.repo.CashbackRepo;

@Service
public class CashbackService 
{
	@Autowired
	private CashbackRepo repo;
	
		public Cashback saveCashback(Cashback cashback)
		{
			return repo.save(cashback);
		}
		
		public List<Cashback> findAllCashback()
		{
			return repo.findAll();
		}
		
		
		public void deleteCashbackById(String id)
		{
			repo.deleteById(id);
		}
		
		
		public Cashback findCashbackById(String id) 
		{
			return repo.findById(id).get();
		}


}
