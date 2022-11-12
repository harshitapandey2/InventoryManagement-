package com.genc.InventoryManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genc.InventoryManagement.exception.ProductNotFoundException;
import com.genc.InventoryManagement.model.ProductEntity;
import com.genc.InventoryManagement.model.ProductResponse;
import com.genc.InventoryManagement.repository.ProductRepository;

@Service
public class ProductUpdateService {
	@Autowired
	ProductRepository prodRepo;
	public ProductResponse updateProduct(ProductEntity prodEntity) {
        ProductEntity prodData = prodRepo.findById(prodEntity.getProductId()).orElseThrow(()-> new ProductNotFoundException("Product not found to update"));
        prodData.setProductId(prodEntity.getProductId());
        prodData.setProductName(prodEntity.getProductName());
        prodData.setShortDescription(prodEntity.getShortDescription());
        prodData.setDetailedDescription(prodEntity.getDetailedDescription());
        
        prodRepo.save(prodData);
        return new ProductResponse("Product successfully updated", prodData);
    }

}
