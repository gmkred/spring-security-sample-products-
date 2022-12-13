package com.springboot.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.products.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	public Product getProductByName(String name);

}
