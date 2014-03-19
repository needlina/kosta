package com.namoosori.namooshop.service.facade;

import java.util.List;

import com.namoosori.namooshop.domain.Product;

public interface ProductService {

	List<Product> getAllProducts();
	
	Product getProduct(int serialNo);
}
