package br.com.rafael.techstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rafael.techstore.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
}
