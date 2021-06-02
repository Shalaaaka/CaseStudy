package com.example.OffersCashback.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.OffersCashback.model.Cashback;

@Repository
public interface CashbackRepo extends MongoRepository<Cashback, String> {

}
