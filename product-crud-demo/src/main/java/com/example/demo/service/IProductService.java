package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;

public interface IProductService {

	
	String saveProduct(Product product);
	
	List<Product> getAllProduct();
	
	Product getProductById(Long prodId);
	
	String deleteProductById(Long prodId);
	
	
}
