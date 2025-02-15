package com.carlosrangel.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.carlosrangel.workshopmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
