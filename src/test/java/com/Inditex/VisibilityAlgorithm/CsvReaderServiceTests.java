package com.Inditex.VisibilityAlgorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CsvReaderServiceTest {
    private CsvReaderService csvReaderService;

    @BeforeEach
    void setUp() {
        csvReaderService = new CsvReaderService();
    }

    @Test
    void testReadProducts() throws IOException {
        String filePath = "path/to/product.csv";
        List<Product> products = csvReaderService.readProducts(filePath);
        assertEquals(3, products.size());
        assertEquals(1L, products.get(0).getId());
        assertEquals(1, products.get(0).getSequence());
        assertEquals(2L, products.get(1).getId());
        assertEquals(2, products.get(1).getSequence());
        assertEquals(3L, products.get(2).getId());
        assertEquals(3, products.get(2).getSequence());
    }

    @Test
    void testReadSizes() throws IOException {
        String filePath = "path/to/size.csv";
        List<Size> sizes = csvReaderService.readSizes(filePath);
        assertEquals(5, sizes.size());
        assertEquals(1L, sizes.get(0).getId());
        assertEquals(1L, sizes.get(0).getProductId());
        assertEquals(false, sizes.get(0).isBackSoon());
        assertEquals(false, sizes.get(0).isSpecial());
    }

    @Test
    void testReadStocks() throws IOException {
        String filePath = "path/to/stock.csv";
        List<Stock> stocks = csvReaderService.readStocks(filePath);
        assertEquals(5, stocks.size());
        assertEquals(1L, stocks.get(0).getSizeId());
        assertEquals(10, stocks.get(0).getQuantity());
    }
}
