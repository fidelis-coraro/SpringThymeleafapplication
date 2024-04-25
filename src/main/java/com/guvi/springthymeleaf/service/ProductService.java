package com.guvi.springthymeleaf.service;

import com.guvi.springthymeleaf.entity.Product;
import com.guvi.springthymeleaf.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getAllProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}

