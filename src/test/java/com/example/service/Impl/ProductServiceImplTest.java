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
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.service.mapper.ProductMapper;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
	
	@Mock
	ProductMapper productMapper;
	
	@Mock
	TaxCalculatorServiceImpl taxCalculatorServiceImpl;
	
	ProductServiceImpl productServiceImpl;
	List<String> data;

	@BeforeEach
    public void setUp() {
		productServiceImpl = mock(ProductServiceImpl.class);
		data = new ArrayList<>();
		data.add("1 book at 12.49");
		data.add("1 imported bottle of perfume at 47.50");
	}
	
	@Test
	void test() {
		doNothing().when(productServiceImpl).calculateTax(data);
	 
		productServiceImpl.calculateTax(data);
		verify(productServiceImpl, times(1)).calculateTax(data);
	}
}
