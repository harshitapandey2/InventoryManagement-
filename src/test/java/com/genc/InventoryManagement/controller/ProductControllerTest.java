package com.genc.InventoryManagement.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.aspectj.weaver.ast.And;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.genc.InventoryManagement.model.ProductEntity;
import com.genc.InventoryManagement.model.ProductRequest;
import com.genc.InventoryManagement.model.ProductResponse;
import com.genc.InventoryManagement.repository.ProductRepository;


@AutoConfigureMockMvc
@SpringBootTest
public class ProductControllerTest {
	@Autowired MockMvc mvc;
	
	ObjectMapper objectMapper = new ObjectMapper();
	ObjectWriter objectWriter= objectMapper.writer();
	//@MockBean ProductAdditionService prodAddService;
	//@MockBean ProductUpdateService prodUpdateService;
	@Mock ProductRepository prodRepo;
	@InjectMocks AdditionController addController ;
	@InjectMocks DeleteController deleteController;
	@InjectMocks SearchController searchController;
	@InjectMocks UpdateController updateController;
	
	
	ProductEntity PRODUCT_1= new ProductEntity(21, "productName1","shortDesc1","deetDesc1","GROCERY",2000.00);
	ProductEntity PRODUCT_2= new ProductEntity(22, "productName2","shortDesc2","deetDesc2","GROCERY",4000.00);
	ProductEntity PRODUCT_3= new ProductEntity(23, "productName3","shortDesc3","deetDesc3","ELECTRONICS",3000.00);
	
	
	public void setUp() {
		//MockitoAnnotations.initMocks(this);
		// this.mvc = MockMvcBuilders.standaloneSetup(addController).build();
	}
	
	
	//CREATE
	@Test
	public void createProductValidDetails() throws Exception 
	{
		
		ProductEntity record = ProductEntity.builder()
				.productId(1)
				.productName("D1")
				.shortDescription("ShortDesc")
				.detailedDescription("detailedDesc")
				.category("ELECTRONICS")
				.price(1000.00)
				.build();
		when(prodRepo.save(record)).thenReturn(record);
		
		String jsonRequest= objectWriter.writeValueAsString(record);
		mvc.perform(post("/p-addition")
				.content(jsonRequest)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	
	//UPDATE
	@Test
	public void updateProductValidDetails() throws Exception 
	{
		/*
		 * ProductRequest request = new ProductRequest("dummy666", "short desc update",
		 * "long desc update", "ELECTRONICS", 1000.00); //POJO
		 * when(prodAddService.addProduct(request)).thenReturn(new
		 * ProductResponse("Successfully Updated", new
		 * ProductEntity(request.getProductName(), request.getShortDescription(),
		 * request.getDetailedDescription(), request.getDetailedDescription(),
		 * request.getPrice()))); String jsonRequest = this.mapToJson(request);
		 * 
		 * 
		 * mvc.perform(put("/p-update").content(jsonRequest).contentType(MediaType.
		 * APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)).andExpect(status(
		 * ).isOk());
		 */
	}
	
	
	
	//SEARCH
	@Test
	public void searchProductInvalidCategory() throws Exception 
	{
		when(prodRepo.findByProductName(PRODUCT_1.getProductName())).thenReturn(Optional.of(PRODUCT_1));
		mvc.perform(get("/p-search/productName1")
				.contentType(MediaType.APPLICATION_JSON))
	          .andExpect(status().isOk());
	
	}
	
	
	
	
	//DELETE
	@Test
	public void deleteProductInvalidCategory() throws Exception 
	{
		when(prodRepo.findById(1)).thenReturn(null);
		mvc.perform(delete("/p-delete/{prodName}", "dummy201")).andExpect(status().isOk());
	}
	
	
	public String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
	
	

	 /* @Test public void createProductInvalidName() throws Exception {
	 * 
	 * ProductRequest request = new ProductRequest("dummy444", "short desc",
	 * "long desc", "ELECTRONICS", 1000.00); //POJO String jsonRequest =
	 * this.mapToJson(request); System.out.println(jsonRequest);
	 * mvc.perform(post("/p-addition").content(jsonRequest).contentType(MediaType.
	 * APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)).andExpect(status(
	 * ).is4xxClientError()); }
	 * 
	 * @Test public void createProductInvalidCategory() throws Exception {
	 * 
	 * ProductRequest request = new ProductRequest("dummy666", "short desc",
	 * "long desc", "INVALID", 1000.00); //POJO String jsonRequest =
	 * this.mapToJson(request); System.out.println(jsonRequest);
	 * mvc.perform(post("/p-addition").content(jsonRequest).contentType(MediaType.
	 * APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)).andExpect(status(
	 * ).is4xxClientError()); } */
	 
}