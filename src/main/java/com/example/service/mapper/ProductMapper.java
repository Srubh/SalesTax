package com.example.service.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.Constants;
import com.example.model.Product;
import com.example.util.ProductEnum;

public class ProductMapper {

	public List<Product> toProuct(List<String> inputText) {
		List<Product> products = new ArrayList<Product>();
		for (String item : inputText) {
			products.add(getDetails(item));
		}
		return products;
	}

	private Product getDetails(String text) {

		Product product = new Product();
		Pattern inputPattern = Pattern.compile(Constants.REGEX_CLASSIFIER, Pattern.CASE_INSENSITIVE);
		Matcher textMatcher = inputPattern.matcher(text);

		if (textMatcher.find()) {
			product.setQuantity(Integer.parseInt(textMatcher.group(1)));
			product.setPrice(Double.parseDouble(textMatcher.group(4)));
			product.setDesc(textMatcher.group(2).trim());
			product.setImported(isImported(product.getDesc()));
			product.setExempt(isExcluded(product.getDesc()));
		}

		return product;
	}

	private boolean isExcluded(String desc) {
		return ProductEnum.getexemptdata().stream()
				.anyMatch(item -> item.getLable().stream().anyMatch(name -> desc.contains(name)));
	}

	private boolean isImported(String desc) {
		return desc.toLowerCase().contains(Constants.IMPORTED.toLowerCase());
	}
}
