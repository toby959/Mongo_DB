package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.exception.NoProductFoundException;
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
		return "Product with Id:" + prodId + " deleted status!" + delete;
	}

	@Override
	public Product updateProduct(Long prodId, Product product)throws NoProductFoundException {
		Optional<Product> existing = prodRepo.findById(prodId);
		Product existProduct = null;
		if(existing.isPresent()) {
			existProduct = existing.get();
			existProduct.setProdName(product.getProdName());
			existProduct.setPrice(product.getPrice());
			existProduct.setDesc(product.getDesc());
			
			prodRepo.save(existProduct);
		}
		if(existProduct == null) {
			throw new NoProductFoundException("Product Not Found");
		}
		return existProduct;
	}

	
}
