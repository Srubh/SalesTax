package com.example.service.Impl;

import java.util.List;

import com.example.model.Product;
import com.example.service.ProductService;
import com.example.service.mapper.ProductMapper;

public class ProductServiceImpl implements ProductService {

	private ProductMapper productMapper;
	private TaxCalculatorServiceImpl taxCalculatorServiceImpl;

	public void calculateTax(List<String> data) {
		// TODO Auto-generated method stub

		// Map to product class
		productMapper = new ProductMapper(data);
		List<Product> items = productMapper.toProuct();

		// Calculate tax
		taxCalculatorServiceImpl = new TaxCalculatorServiceImpl(items);
		taxCalculatorServiceImpl.computeTax();

		//Print receipt details
		print(items);
	}

	private void print(List<Product> items) {
		// TODO Auto-generated method stub
		for (Product item : items) {
			double total = (double) Math.round((item.getPrice() + item.getImportTax() + item.getSalesTax()) * 100)
					/ 100;
			System.out.println(item.getQuantity() + " " + item.getDesc() + " :" + total);
		}
		System.out.println("Sales Taxes: " + taxCalculatorServiceImpl.getSalesTaxes());
		System.out.println("Total " + taxCalculatorServiceImpl.getTotalAll());
		System.out.println();
	}

}
