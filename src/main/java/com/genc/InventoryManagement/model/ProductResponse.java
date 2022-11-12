package com.genc.InventoryManagement.model;

public class ProductResponse {
	private String message;
	private ProductEntity prodEntity;
	public ProductResponse(String message, ProductEntity prodEntity) {
		super();
		this.message = message;
		this.prodEntity = prodEntity;
	}
	public ProductResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ProductEntity getProdEntity() {
		return prodEntity;
	}
	public void setProdEntity(ProductEntity prodEntity) {
		this.prodEntity = prodEntity;
	}
	
	
}
