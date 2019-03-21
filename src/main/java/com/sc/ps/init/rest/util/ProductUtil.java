package com.sc.ps.init.rest.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import com.sc.ps.init.rest.models.Product;
import com.sc.ps.init.rest.response.Feedback;
import com.sc.ps.init.rest.response.ProductResponse;

public class ProductUtil {
	private ProductUtil() {
	}

	public static ProductResponse toProductResponse(Product p) {
		ProductResponse pr = new ProductResponse();
		pr.setProductId(p.getProductId());
		pr.setProductName(p.getProductName());
		pr.setProductDescription(p.getProductDescription());
		return pr;
	}

	public static ProductResponse toProductResponse(Product p, List<Feedback> feedbacks) {
		ProductResponse pr = toProductResponse(p);

		if (!CollectionUtils.isEmpty(feedbacks)) {
			float totalRating = feedbacks.stream().mapToInt(fb -> fb.getStarRating()).sum();
			float averageRating = totalRating / feedbacks.size();
			pr.setAverageRating(averageRating);
			pr.setFeedbacks(feedbacks);
		}
		return pr;
	}

	public static List<ProductResponse> toProductsResponse(List<Product> products) {
		List<ProductResponse> productResponses = new ArrayList<>();

		products.forEach(p -> productResponses.add(toProductResponse(p)));

		return productResponses;
	}

	public static List<ProductResponse> toProductsResponse(List<Product> products, List<Feedback> feedbacks) {
		List<ProductResponse> productResponses = new ArrayList<>();
		products.forEach(p -> {
			List<Feedback> fb = feedbacks.stream()
					.filter(f -> f.getProductId().equals(p.getProductId()))
					.collect(Collectors.toList());
			productResponses.add(toProductResponse(p, fb));
		});
		return productResponses;
	}
}
