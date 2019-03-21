package com.sc.ps.init.rest.exception.business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sc.ps.init.rest.exception.ProductServiceException;
import com.sc.ps.init.rest.exception.ProductServiceException.ProductError;
import com.sc.ps.init.rest.models.Product;
import com.sc.ps.init.rest.repository.ProductServiceRepository;

@Component
public class ProductServiceBusiness {
	private ProductServiceRepository repository;

	public ProductServiceBusiness(ProductServiceRepository repository) {
		this.repository = repository;
	}

	public Product createProduct(Product product) {
		return repository.insert(product);
	}

	public List<Product> createProduct(List<Product> products) {
		return repository.insert(products);
	}

	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	public Product getProduct(String id) {
		Optional<Product> foundProduct = repository.findById(id);
		if (!foundProduct.isPresent()) {
			throw new ProductServiceException(ProductError.NO_PRODUCT);
		}
		return foundProduct.get();
	}
	
	public Product updateProduct(Product product) {
		return repository.save(product);
	}
}
