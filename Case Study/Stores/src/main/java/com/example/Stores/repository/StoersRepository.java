package com.example.Stores.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Stores.model.Stores;

@Repository
public interface StoersRepository extends MongoRepository<Stores, String>
{	
}
