package com.example.util;

import java.util.Arrays;
import java.util.List;

public enum ProductEnum {
	BOOK ("book"), 
	FOOD ("chocolate"), 
	Medicine ("pills");
	
	ProductEnum(String lable) {
		// TODO Auto-generated constructor stub
		this.lable = lable;
	}

	private String lable;
	
	public String getLable() {
		return lable;
	}

	public void setLable(String lable) {
		this.lable = lable;
	}

	public static List<ProductEnum> getexemptdata() {
        return Arrays.asList(ProductEnum.values());
    }
}
