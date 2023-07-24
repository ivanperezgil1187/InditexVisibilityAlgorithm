package com.Inditex.VisibilityAlgorithm;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SizeTest {
    @Test
    void testSize() {
        Size size = new Size();
        size.setId(1);
        size.setProductId(101);
        size.setBackSoon(true);
        size.setSpecial(false);

        assertEquals(1, size.getId());
        assertEquals(101, size.getProductId());
        assertEquals(true, size.isBackSoon());
        assertEquals(false, size.isSpecial());
    }
}
