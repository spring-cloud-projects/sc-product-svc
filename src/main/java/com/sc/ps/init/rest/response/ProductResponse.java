package com.sc.ps.init.rest.response;

import java.util.List;

import lombok.Data;

@Data
public class ProductResponse {
	private ServiceError error;
	private String productId;
	private String productName;
	private String productDescription;
	private float averageRating;
	private List<Feedback> feedbacks;
}
