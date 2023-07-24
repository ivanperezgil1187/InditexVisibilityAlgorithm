package com.Inditex.VisibilityAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VisibilityService {
    public List<Integer> getVisibleProducts(List<Product> products, List<Size> sizes, List<Stock> stocks) {
        List<Integer> visibleProducts = new ArrayList<>();

        for (Product product : products) {
            List<Size> productSizes = sizes.stream()
                    .filter(size -> size.getProductId() == product.getId())
                    .collect(Collectors.toList());

            boolean hasSpecialSizeInStock = false;
            boolean hasNonSpecialSizeInStock = false;
            boolean hasBackSoonSize = false;

            for (Size size : productSizes) {
                int quantity = getStockQuantity(size.getId(), stocks);
                if (quantity > 0 || size.isBackSoon()) {
                    if (size.isSpecial()) {
                        hasSpecialSizeInStock = true;
                    } else {
                        hasNonSpecialSizeInStock = true;
                    }
                }
                if (size.isBackSoon()) {
                    hasBackSoonSize = true;
                }
            }

            if ((hasSpecialSizeInStock && hasNonSpecialSizeInStock) || hasBackSoonSize) {
                visibleProducts.add(product.getId());
            }
        }

        return visibleProducts;
    }

    private int getStockQuantity(int sizeId, List<Stock> stocks) {
        Stock stock = stocks.stream()
                .filter(s -> s.getSizeId() == sizeId)
                .findFirst()
                .orElse(null);

        return stock != null ? stock.getQuantity() : 0;
    }
}

