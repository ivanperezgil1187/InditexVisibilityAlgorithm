package com.Inditex.VisibilityAlgorithm;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StockTest {
    @Test
    void testStock() {
        Stock stock = new Stock();
        stock.setSizeId(1);
        stock.setQuantity(50);

        assertEquals(1, stock.getSizeId());
        assertEquals(50, stock.getQuantity());
    }
}

