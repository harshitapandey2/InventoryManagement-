package com.genc.InventoryManagement.model;

public class ProductUpdateRequest {
	private String productName;
	private String shortDescription;
	private String detailedDescription;
	private Double price;
	public ProductUpdateRequest(String productName, String shortDescription, String detailedDescription, Double price) {
		super();
		this.productName = productName;
		this.shortDescription = shortDescription;
		this.detailedDescription = detailedDescription;
		this.price = price;
	}
	public ProductUpdateRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getDetailedDescription() {
		return detailedDescription;
	}
	public void setDetailedDescription(String detailedDescription) {
		this.detailedDescription = detailedDescription;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	

}
