package com.smiley.microservices.product.repositories;

import com.smiley.microservices.product.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {
}
