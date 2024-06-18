package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.IProductService;

@RestController
@RequestMapping("/product/")
public class ProductController {

	@Autowired
	IProductService iProductService; 
	
	@PostMapping("/save")
	public ResponseEntity<String> createProduct(@RequestBody Product product){
		
		return new ResponseEntity<String>(iProductService.saveProduct(product), HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Product>> readAllProduct(){
		return new ResponseEntity<List<Product>>(iProductService.getAllProduct(), HttpStatus.OK);
	}
		
	
	@GetMapping("/get/{prodId}")
	public ResponseEntity<Product> readProductById(@PathVariable Long prodId){
		return new ResponseEntity<Product>(iProductService.getProductById(prodId), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{prodId}")
	public ResponseEntity<String> deleteById(@PathVariable Long prodId){
		return new ResponseEntity<String> (iProductService.deleteProductById(prodId),HttpStatus.OK);
	}
 
	
}
