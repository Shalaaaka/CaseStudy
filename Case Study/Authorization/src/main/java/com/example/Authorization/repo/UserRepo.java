package com.example.Authorization.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Authorization.model.User;

@Repository
public interface UserRepo extends MongoRepository<User, String> 
{
	Optional<User> findByEmailId(String emailid);
}
