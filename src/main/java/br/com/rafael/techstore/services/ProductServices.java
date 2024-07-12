package br.com.rafael.techstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.rafael.techstore.models.Product;
import br.com.rafael.techstore.repositories.ProductRepository;

@Service
public class ProductServices {

    @Autowired(required = true)
    ProductRepository productRepository;

    public Page<Product> findAll(Pageable pageable) {
        return this.productRepository.findAll(pageable);
    }
}