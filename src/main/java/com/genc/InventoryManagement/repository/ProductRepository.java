package com.genc.InventoryManagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.genc.InventoryManagement.model.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity,Integer>{
	public Optional<ProductEntity> findByProductName(String productName);

}
