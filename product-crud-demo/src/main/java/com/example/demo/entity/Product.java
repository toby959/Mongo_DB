package com.example.demo.entity;




import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;






@Document
public class Product {

	@Id
	private Long prodId;
	
	private String prodName;
	
	
	private double price;
	
	
	private String desc;


	public Long getProdId() {
		return prodId;
	}


	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}


	public String getProdName() {
		return prodName;
	}


	public void setProdName(String prodName) {
		this.prodName = prodName;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", price=" + price + ", desc=" + desc
				+ ", getProdId()=" + getProdId() + ", getProdName()=" + getProdName() + ", getPrice()=" + getPrice()
				+ ", getDesc()=" + getDesc() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


	

	
}
