package com.userman.usermanager.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.userman.usermanager.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
