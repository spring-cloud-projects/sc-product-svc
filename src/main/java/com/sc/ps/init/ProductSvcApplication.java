package com.sc.ps.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.sc.ps")
public class ProductSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductSvcApplication.class, args);
	}

}
