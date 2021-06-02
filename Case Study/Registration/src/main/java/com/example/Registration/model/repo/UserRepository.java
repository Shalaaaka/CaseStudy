package com.example.Registration.model.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Registration.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> 
{
	User findByEmailId(String emailId);

	User findByEmailIdAndPassword(String email, String password);
}
