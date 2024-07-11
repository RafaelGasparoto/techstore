package br.com.rafael.techstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafael.techstore.models.Product;
import br.com.rafael.techstore.repositories.ProductRepository;

@Service
public class ProductServices {

    @Autowired(required = true)
    ProductRepository productRepository;

    public List<Product> findAll() {
        return this.productRepository.findAll();
    }
}