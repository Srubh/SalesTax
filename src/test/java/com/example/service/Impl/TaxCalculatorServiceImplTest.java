package com.example.service.Impl;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.model.Product;

@ExtendWith(MockitoExtension.class)
class TaxCalculatorServiceImplTest {
	
	TaxCalculatorServiceImpl texCalculatorServiceImpl;
	Product product1;
    Product product2;
    List<Product> listProducts;
    
	@BeforeEach
    public void setUp() {
		texCalculatorServiceImpl = mock(TaxCalculatorServiceImpl.class);
		listProducts = new ArrayList<>();
		
		product1 = new Product();
		product1.setDesc("book");
		product1.setQuantity(1);
		product1.setPrice(12.49);
		product1.setExempt(true);
		product1.setImported(false);
		listProducts.add(product1);
		
		product2 = new Product();
		product2.setDesc("imported bottle of perfume");
		product2.setQuantity(1);
		product2.setPrice(47.50);
		product2.setExempt(false);
		product2.setImported(true);
		listProducts.add(product2);
	}
	
	@Test
	void test() {
		
		doNothing().when(texCalculatorServiceImpl).computeTax(listProducts);
		 
		texCalculatorServiceImpl.computeTax(listProducts);
		verify(texCalculatorServiceImpl, times(1)).computeTax(listProducts);
	}

}
