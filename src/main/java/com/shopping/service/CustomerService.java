package com.shopping.service;

import java.util.List;
import com.shopping.Entities.CustomerDetails;


public interface CustomerService {

	CustomerDetails createCustomer(CustomerDetails customer);
	String deleteCustomer(int id);
	CustomerDetails updateCustomer(int id,CustomerDetails customer);
	CustomerDetails getCustomerById(int id);
	List<CustomerDetails> getAllCustomer();
	CustomerDetails findByCustomerNameAndEmailAndPassword(String customerName,String email,String password);
	List<CustomerDetails> getCustomerByName(String customerName);
	CustomerDetails getCustomerByEmail(String email);
	
	
}
