package com.namoosori.namooshop.service.facade;

import com.namoosori.namooshop.domain.Customer;

public interface CustomerService {
	
	boolean login(String userId, String password);
	
	Customer getCustomer(String userId);

}
