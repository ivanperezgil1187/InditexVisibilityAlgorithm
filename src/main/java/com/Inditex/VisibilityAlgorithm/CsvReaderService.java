package com.Inditex.VisibilityAlgorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderService {
	public List<Product> readProducts(String filePath) throws IOException {
		List<Product> products = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				Product product = new Product();
				product.setId(Integer.parseInt(data[0].trim()));
				product.setSequence(Integer.parseInt(data[1].trim()));
				products.add(product);
			}
		}
		return products;
	}

	public List<Size> readSizes(String filePath) throws IOException {
		List<Size> sizes = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				Size size = new Size();
				size.setId(Integer.parseInt(data[0].trim()));
				size.setProductId(Integer.parseInt(data[1].trim()));
				size.setBackSoon(Boolean.parseBoolean(data[2].trim()));
				size.setSpecial(Boolean.parseBoolean(data[3].trim()));
				sizes.add(size);
			}
		}
		return sizes;
	}

	public List<Stock> readStocks(String filePath) throws IOException {
		List<Stock> stocks = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				Stock stock = new Stock();
				stock.setSizeId(Integer.parseInt(data[0].trim()));
				stock.setQuantity(Integer.parseInt(data[1].trim()));
				stocks.add(stock);
			}
		}
		return stocks;
	}
}
