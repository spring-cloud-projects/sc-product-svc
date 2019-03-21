package com.sc.ps.init.rest.response;

import lombok.Data;

@Data
public class ServiceError {
	private int errorCode;
	private String errorMessage;
	private String timeStamp;
}
