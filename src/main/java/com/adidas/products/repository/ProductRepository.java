package com.adidas.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adidas.products.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}
