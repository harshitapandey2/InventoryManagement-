package com.genc.InventoryManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genc.InventoryManagement.exception.ProductNotFoundException;
import com.genc.InventoryManagement.model.ProductEntity;
import com.genc.InventoryManagement.repository.ProductRepository;

@Service
public class ProductSearchService {
	@Autowired
	ProductRepository prodRepo;
	public ProductEntity searchProduct(String prodName) {
		return prodRepo.findByProductName(prodName).orElseThrow(()-> new ProductNotFoundException(prodName));
		
	}

}
