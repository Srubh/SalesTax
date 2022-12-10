package com.example.service.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.model.Product;

@ExtendWith(MockitoExtension.class)
class ProductMapperTest {
	
	@InjectMocks
    private ProductMapper productMapper;
	
    Product product1;
    Product product2;
    List<String> data;
	
	@BeforeEach
    public void setUp() {
		data = new ArrayList<>();
		data.add("1 book at 12.49");
		data.add("1 imported bottle of perfume at 47.50");
		
		product1 = new Product();
		product1.setDesc("book");
		product1.setQuantity(1);
		product1.setPrice(12.49);
		product1.setExempt(true);
		product1.setImported(false);
		
		product2 = new Product();
		product2.setDesc("imported bottle of perfume");
		product2.setQuantity(1);
		product2.setPrice(47.50);
		product2.setExempt(false);
		product2.setImported(true);
	}
	
	@Test
    public void toCompute_GivenInputList_ThenProductsAreCreated() throws Exception {
        List<Product> testProducts = productMapper.toProuct(data);
        
        assertEquals(testProducts.get(0), product1);
        assertEquals(testProducts.get(1), product2);
	}
	
}
