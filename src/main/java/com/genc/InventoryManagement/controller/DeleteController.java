package com.genc.InventoryManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.genc.InventoryManagement.model.ProductEntity;
import com.genc.InventoryManagement.service.ProductDeleteService;

@RestController
public class DeleteController {
	@Autowired
	ProductDeleteService prodService;
	
	@DeleteMapping("/p-delete/{prodId}")
	public ResponseEntity<ProductEntity> deleteController(@PathVariable String prodId) {
		
		return new ResponseEntity<ProductEntity>(prodService.deleteProduct(Integer.parseInt(prodId)),HttpStatus.OK);

		
		
	}
}
