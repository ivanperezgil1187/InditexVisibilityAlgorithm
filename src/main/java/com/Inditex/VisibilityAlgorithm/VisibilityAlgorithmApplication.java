package com.Inditex.VisibilityAlgorithm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VisibilityAlgorithmApplication {

	private static final String SEPARATOR = ",";

	private final static CsvReaderService csvReaderService = new CsvReaderService();
	private final static VisibilityService visibilityService = new VisibilityService();

	public static void main(String[] args) {

		Properties appConfiguration;
		try {
			appConfiguration = readPropertiesFile("application.properties");

			String datasourcePath = appConfiguration.getProperty("datasource.path");
			String productsFile = appConfiguration.getProperty("datasource.productsFile");
			String sizesFile = appConfiguration.getProperty("datasource.sizesFile");
			String stocksFile = appConfiguration.getProperty("datasource.stocksFile");

			List<Product> products = csvReaderService.readProducts(datasourcePath + "\\" + productsFile);
			List<Size> sizes = csvReaderService.readSizes(datasourcePath + "\\" + sizesFile);
			List<Stock> stocks = csvReaderService.readStocks(datasourcePath + "\\" + stocksFile);

			System.out.println(visibilityService.getVisibleProducts(products, sizes, stocks));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Properties readPropertiesFile(String fileName) throws IOException {
		InputStream fis = null;
		Properties prop = null;
		try {
			fis = getFileFromResourceAsStream(fileName);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			fis.close();
		}
		return prop;
	}

	public static InputStream getFileFromResourceAsStream(String fileName) {

		ClassLoader classLoader = VisibilityAlgorithmApplication.class.getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream(fileName);

		if (inputStream == null) {
			throw new IllegalArgumentException("file not found! " + fileName);
		} else {
			return inputStream;
		}

	}
}
