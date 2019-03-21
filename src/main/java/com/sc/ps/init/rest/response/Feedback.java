package com.sc.ps.init.rest.response;

import lombok.Data;

@Data
public class Feedback {
	private String productId;
	private int starRating;
	private String comment;
	private String commentBy;
	private String timestamp;
}
