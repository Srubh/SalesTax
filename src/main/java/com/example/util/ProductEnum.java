package com.example.util;

import java.util.Arrays;
import java.util.List;

public enum ProductEnum {
	BOOK (new String[]{"book"}), 
	FOOD (new String[]{"chocolate"}), 
	Medicine (new String[]{"pills"});
	
	ProductEnum(String[] lable) {
		// TODO Auto-generated constructor stub
		this.lable = lable;
	}

	private String[] lable;
	
	public List<String> getLable() {
		return Arrays.asList(lable);
	}

	public void setLable(String[] lable) {
		this.lable = lable;
	}

	public static List<ProductEnum> getexemptdata() {
        return Arrays.asList(ProductEnum.values());
    }
}
