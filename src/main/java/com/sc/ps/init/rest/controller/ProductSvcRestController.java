package com.sc.ps.init.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sc.ps.init.rest.exception.business.ProductServiceBusiness;
import com.sc.ps.init.rest.models.Product;
import com.sc.ps.init.rest.response.ProductResponse;
import com.sc.ps.init.rest.util.ProductUtil;

@RestController("/prodsvc")
public class ProductSvcRestController {
	private ProductServiceBusiness business;

	public ProductSvcRestController(ProductServiceBusiness business) {
		this.business = business;
	}

	@PostMapping(value="/create", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ProductResponse> createProduct(@RequestBody Product product) {
		Product savedProduct = business.createProduct(product);
		ProductResponse pr = ProductUtil.toProductResponse(savedProduct);
		return new ResponseEntity<>(pr, HttpStatus.CREATED);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ProductResponse>> getAllProducts() {
		List<Product> products = business.getAllProducts();
		List<ProductResponse> pr = ProductUtil.toProductsResponse(products);
		return new ResponseEntity<>(pr, HttpStatus.CREATED);
	}
}
