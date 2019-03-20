package com.sc.ps.init.rest.exception.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sc.ps.init.rest.exception.ProductServiceException;

public class ProductServiceExceptionHandler {

	@ExceptionHandler(value = { ProductServiceException.class })
	public void handleException() {

	}
}
