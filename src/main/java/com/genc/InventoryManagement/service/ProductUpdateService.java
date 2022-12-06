package com.genc.InventoryManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genc.InventoryManagement.exception.ProductNotFoundException;
import com.genc.InventoryManagement.model.ProductEntity;
import com.genc.InventoryManagement.model.ProductResponse;
import com.genc.InventoryManagement.model.ProductUpdateRequest;
import com.genc.InventoryManagement.repository.ProductRepository;

@Service
public class ProductUpdateService {
	@Autowired
	ProductRepository prodRepo;
	public ProductResponse updateProduct(ProductUpdateRequest prodRequest) {
        ProductEntity prodData = prodRepo.findByProductName(prodRequest.getProductName()).orElseThrow(()-> new ProductNotFoundException("Product not found to update"));
        prodData.setProductName(prodRequest.getProductName());
        prodData.setShortDescription(prodRequest.getShortDescription());
        prodData.setDetailedDescription(prodRequest.getDetailedDescription());
        prodData.setPrice(prodRequest.getPrice());
        prodRepo.save(prodData);
        return new ProductResponse("Product successfully updated", prodData);
    }

}
