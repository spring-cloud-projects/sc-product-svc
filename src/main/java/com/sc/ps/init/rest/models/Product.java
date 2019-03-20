package com.sc.ps.init.rest.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Product {
	private String productId;
	private String productName;
	private String productDescription;
}
