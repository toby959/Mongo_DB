package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;
import com.example.demo.exception.NoProductFoundException;

public interface IProductService {

	
	String saveProduct(Product product);
	
	List<Product> getAllProduct();
	
	Product getProductById(Long prodId);
	
	String deleteProductById(Long prodId);
	
	Product updateProduct(Long prodId, Product product) throws NoProductFoundException;   
}
