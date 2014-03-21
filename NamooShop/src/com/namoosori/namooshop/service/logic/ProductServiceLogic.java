package com.namoosori.namooshop.service.logic;

import java.util.List;

import com.namoosori.namooshop.data.ProductRepository;
import com.namoosori.namooshop.domain.Product;
import com.namoosori.namooshop.service.facade.ProductService;

public class ProductServiceLogic implements ProductService {

	private ProductRepository productRepo;
	
	public ProductServiceLogic() {
		//
		productRepo = ProductRepository.getInstance();
	}
	
	@Override
	public List<Product> getAllProducts() {
		// 
		return productRepo.findAllProducts();
	}

	@Override
	public Product getProduct(int serialNo) {
		// 
		if (serialNo == 1) {
			throw new RuntimeException("해당 상품의 재고가 없습니다.");
		}
		
		return productRepo.findProductByNo(serialNo);
	}
}
