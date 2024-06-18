package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepository;


@Service
public class ProductService implements IProductService{

	@Autowired
	private ProductRepository prodRepo;
	
	@Override
	public String saveProduct(Product product) {
		prodRepo.save(product);
		return "Product id: " + product.getProdId() + " is saved seccessfully!";
	}

	@Override
	public List<Product> getAllProduct() {
		
		return prodRepo.findAll();
	}

	@Override
	public Product getProductById(Long prodId) {
		
		return prodRepo.findById(prodId).orElse(null);
	}

	@Override
	public String deleteProductById(Long prodId) {
		boolean delete = false;
		if(prodRepo.existsById(prodId)) {
			prodRepo.deleteById(prodId);
			delete = true;
		}
		return "Prodcut with Id:" + prodId + " deleted status!" + delete;
	}

	
	
}
