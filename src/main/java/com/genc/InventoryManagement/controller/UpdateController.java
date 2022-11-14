package com.genc.InventoryManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.genc.InventoryManagement.model.ProductResponse;
import com.genc.InventoryManagement.model.ProductUpdateRequest;
import com.genc.InventoryManagement.service.ProductUpdateService;

@RestController
@CrossOrigin("http://localhost:4200")
public class UpdateController {
	@Autowired
	ProductUpdateService prodUpdate;
	
	@PutMapping("/p-update")
	public ResponseEntity<ProductResponse> updateController(@RequestBody ProductUpdateRequest product) {
		return new ResponseEntity<ProductResponse>(prodUpdate.updateProduct(product), HttpStatus.OK);

}
}
