package com.deepak.springreactivecassandraexample.controller;

import com.deepak.springreactivecassandraexample.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public Flux getProducts() {
        return productRepository.findAll();
    }
}
