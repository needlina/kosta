package com.namoosori.namooshop.data;

import java.util.HashMap;
import java.util.Map;

import com.namoosori.namooshop.domain.Customer;

public class CustomerRepository {
	
	private Map<String, Customer> customersMap;
	
	private static CustomerRepository instance = new CustomerRepository();
	
	public static CustomerRepository getInstance() {
		//
		return instance;
	}
	
	//--------------------------------------------------------------------------
	private CustomerRepository() {
		//
		customersMap = new HashMap<String, Customer>();
		customersMap.put("bookmania", new Customer("김붕만", "bookmania", "1234"));
		customersMap.put("booklove", new Customer("박사랑", "booklove", "adsf"));
	}

	public Customer findCustomerById(String userId) {
		return customersMap.get(userId);
	}
}
