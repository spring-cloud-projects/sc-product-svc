package com.sc.ps.init.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sc.ps.init.rest.models.Product;

@Repository
public interface ProductServiceRepository extends MongoRepository<Product, String>{

}
