package com.Inditex.VisibilityAlgorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VisibilityServiceTest {
	
    @Mock
    private CsvReaderService csvReaderService;

    @InjectMocks
    private VisibilityService visibilityService;

    private List<Product> mockProducts;
    private List<Size> mockSizes;
    private List<Stock> mockStocks;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        mockProducts = new ArrayList<>();
        mockProducts.add(new Product(1, 1));
        mockProducts.add(new Product(2, 2));
        mockProducts.add(new Product(3, 3));

        mockSizes = new ArrayList<>();
        mockSizes.add(new Size(1, 1, false, false));
        mockSizes.add(new Size(2, 1, true, false));
        mockSizes.add(new Size(3, 2, false, true));
        mockSizes.add(new Size(4, 3, false, true));
        mockSizes.add(new Size(5, 3, false, false));

        mockStocks = new ArrayList<>();
        mockStocks.add(new Stock(1, 10));
        mockStocks.add(new Stock(2, 0));
        mockStocks.add(new Stock(3, 20));
        mockStocks.add(new Stock(4, 0));
        mockStocks.add(new Stock(5, 0));
    }

    @Test
    void testGetVisibleProducts() {

        List<Integer> visibleProducts = visibilityService.getVisibleProducts(mockProducts, mockSizes, mockStocks);
        assertEquals(2, visibleProducts.size());
        assertEquals(1, visibleProducts.get(0));
        assertEquals(3, visibleProducts.get(1));
    }
}
