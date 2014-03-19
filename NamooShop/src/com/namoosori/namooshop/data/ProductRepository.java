package com.namoosori.namooshop.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.namoosori.namooshop.domain.Product;

public class ProductRepository {
	
	private Map<Integer, Product> productsMap;
	
	private static ProductRepository instance = new ProductRepository();
	
	public static ProductRepository getInstance() {
		//
		return instance;
	}
	
	//--------------------------------------------------------------------------
	private ProductRepository() {
		//
		productsMap = new HashMap<Integer, Product>();
		productsMap.put(1, new Product(1, "Java를 배워요", 10000, 4));
		productsMap.put(2, new Product(2, "JSP/Servlet 일주일 벼락치기", 20000, 2));
		productsMap.put(3, new Product(3, "JavaScript 기초", 15000, 4));
	}
	
	public Product findProductByNo(int serialNo) {
		//
		return productsMap.get(serialNo);
	}
	
	public List<Product> findAllProducts() {
		//
		return new ArrayList<Product>(productsMap.values());
	}
}
