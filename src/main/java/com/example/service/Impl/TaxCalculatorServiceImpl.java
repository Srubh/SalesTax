package com.example.service.Impl;

import java.util.List;

import com.example.Constants;
import com.example.model.Product;

public class TaxCalculatorServiceImpl {

	private double total;
	private double salesTaxes;

	public void computeTax(List<Product> products) {

		for (Product item : products) {

			if (!item.isExempted())
				item.setSalesTax(roundNo(item.getPrice() * Constants.BASIC_SALES_TAX_RATE));

			if (item.isImported())
				item.setImportTax(roundNo(item.getPrice() * Constants.IMPORT_TAX_RATE));

			total = total + item.getPrice();
			salesTaxes = salesTaxes + item.getTotalTax();
		}
	}

	private double roundNo(double amount) {
		return (double) Math.ceil(amount / Constants.NEAREST_APPROX) * Constants.NEAREST_APPROX;
	}

	public double getTotalAll() {
		return (double) Math.round((total + salesTaxes) * 100) / 100;
	}

	public double getSalesTaxes() {
		return (double) Math.round(salesTaxes * 100) / 100;
	}

}
