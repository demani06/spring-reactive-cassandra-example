package com.deepak.springreactivecassandraexample.repository;

import com.deepak.springreactivecassandraexample.model.Product;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

public interface ProductRepository extends ReactiveCassandraRepository<Product, String> {

}