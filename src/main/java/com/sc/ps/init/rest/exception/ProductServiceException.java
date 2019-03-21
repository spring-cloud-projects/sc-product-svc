package com.sc.ps.init.rest.exception;

import lombok.Getter;

@Getter
public class ProductServiceException extends RuntimeException {
	private static final long serialVersionUID = 1001746005807984246L;

	private int errorCode;
	private ProductError error;

	public ProductServiceException(String message) {
		super(message);
	}

	public ProductServiceException(int errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public ProductServiceException(ProductError error) {
		super(error.getMessage());
		this.error = error;
	}

	@Getter
	public static enum ProductError {
		NO_PRODUCT(599, "No Product Found");

		private int code;
		private String message;

		private ProductError(int code, String message) {
			this.code = code;
			this.message = message;
		}

	}

}
