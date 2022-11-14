package com.genc.InventoryManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.genc.InventoryManagement.model.ProductEntity;
import com.genc.InventoryManagement.service.ProductSearchService;

@RestController
@CrossOrigin("http://localhost:4200")
public class SearchController {
	@Autowired
	ProductSearchService prodService;
	@GetMapping("/p-search/{prodName}")
	public ResponseEntity<ProductEntity > searchController(@PathVariable String prodName) {
		return new ResponseEntity<ProductEntity>(prodService.searchProduct(prodName),HttpStatus.OK);
		
	}
}
