package com.springreactivemongo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.springreactivemongo.model.Product;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String>{

}
