package com.Inditex.VisibilityAlgorithm;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {
    
	@Test
    void testProduct() {
        Product product = new Product();
        product.setId(1);
        product.setSequence(10);

        assertEquals(1, product.getId());
        assertEquals(10, product.getSequence());
    }
}
