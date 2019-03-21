package com.sc.ps.init.rest.models;

import javax.annotation.Generated;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@Id
	@Generated("AUTO")
	private String productId;
	private String productName;
	private String productDescription;
}
