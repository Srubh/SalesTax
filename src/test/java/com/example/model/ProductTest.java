package com.example.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ProductTest {
	
    @Test
    void equalsVerifier() throws Exception {

        Product product1 = new Product();
        product1.setDesc("desc1");
        Product product2 = new Product();
        product2.setDesc(product1.getDesc());
        Assert.assertEquals(product1, product2);
        product2.setDesc("desc2");
        Assert.assertNotEquals(product1, product2);
        product2.setDesc(null);
        Assert.assertNotEquals(product1, product2);
    }
}
