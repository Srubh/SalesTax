package com.example.model;

public class Product {
	private String desc;

	private int quantity;

	private double price;

	private boolean isImported;

	private boolean isExempted;

	private double importTax;

	private double salesTax;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isImported() {
		return isImported;
	}

	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}

	public boolean isExempted() {
		return isExempted;
	}

	public void setExempt(boolean isExempted) {
		this.isExempted = isExempted;
	}

	public double getImportTax() {
		return importTax;
	}

	public void setImportTax(double importTax) {
		this.importTax = importTax;
	}

	public double getSalesTax() {
		return salesTax;
	}

	public void setSalesTax(double salesTax) {
		this.salesTax = salesTax;
	}

	public double getTotalTax() {
		return this.salesTax + this.importTax;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Product)) {
			return false;
		}
		return desc != null && desc.equals(((Product) o).desc);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	@Override
	public String toString() {
		return "Product [description=" + desc + ", quantity=" + quantity + ", price=" + price + ", isImported="
				+ isImported + ", isExempt=" + isExempted + ", importTax=" + importTax + ", salesTax=" + salesTax + "]";
	}

}
