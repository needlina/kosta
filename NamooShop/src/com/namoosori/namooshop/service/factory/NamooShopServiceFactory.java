package com.namoosori.namooshop.service.factory;

import com.namoosori.namooshop.service.facade.CustomerService;
import com.namoosori.namooshop.service.facade.OrderService;
import com.namoosori.namooshop.service.facade.ProductService;
import com.namoosori.namooshop.service.logic.CustomerServiceLogic;
import com.namoosori.namooshop.service.logic.OrderServiceLogic;
import com.namoosori.namooshop.service.logic.ProductServiceLogic;

public class NamooShopServiceFactory {
	
	private static NamooShopServiceFactory instance = new NamooShopServiceFactory();
	
	public static NamooShopServiceFactory getInstance() {
		//
		return instance;
	}
	
	private NamooShopServiceFactory() {
		//
	}

	public CustomerService getCustomerService() {
		return new CustomerServiceLogic();
	}
	
	public ProductService getProductService() {
		return new ProductServiceLogic();
	}
	
	public OrderService getOrderService() {
		return new OrderServiceLogic();
	}
}
