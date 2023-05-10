package com.shopping.serviceimpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopping.Entities.CustomerDetails;
import com.shopping.exception.ResourceNotFoundException;
import com.shopping.repositories.CustomerRepositoy;
import com.shopping.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired 
	private CustomerRepositoy customerRepository;
	
	@Override
	public CustomerDetails createCustomer(CustomerDetails customer) {
		
		return customerRepository.save(customer);
	}
	
	@Override
	public String deleteCustomer(int id) {
		String message=null;
		Optional<CustomerDetails> customer = customerRepository.findById(id);
		if(customer.isPresent()) {
			customerRepository.deleteById(id);
			message=new String("Customer record deleted successfully!!");
		}
		else {
			throw new ResourceNotFoundException("Customer","id",id);
		}
		return message;
	}

	@Override
	public CustomerDetails updateCustomer(int id, CustomerDetails customer) {
		CustomerDetails existingCustomer = customerRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Customer", "id", id));
		
		
		existingCustomer.setCustomerName(customer.getCustomerName());
		existingCustomer.setPassword(customer.getPassword());
		existingCustomer.setEmail(customer.getEmail());
		existingCustomer.setAge(customer.getAge());
		existingCustomer.setGender(customer.getGender());
		existingCustomer.setPhno(customer.getPhno());
		existingCustomer.setAddress(customer.getAddress());
		
		customerRepository.save(existingCustomer);
		return existingCustomer;
	}

	@Override
	public CustomerDetails getCustomerById(int id) {
		CustomerDetails customerById = customerRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Customer", "id", id));
		
		return customerById;
	}

	@Override
	public List<CustomerDetails> getAllCustomer() {
		List<CustomerDetails> customerAll = customerRepository.findAll();
		return customerAll;
	}

	@Override
	public CustomerDetails findByCustomerNameAndEmailAndPassword(String customerName, String email, String password) {
		CustomerDetails customerBynameEmailPassword=customerRepository.findByCustomerNameAndEmailAndPassword(customerName, email,password);
		return customerBynameEmailPassword;
	}

	@Override
	public List<CustomerDetails> getCustomerByName(String customerName) {
		List<CustomerDetails> customerByName= customerRepository.getCustomerByName(customerName);
		return customerByName;
	}

	@Override
	public CustomerDetails getCustomerByEmail(String email) {
		return customerRepository.getCustomerByEmail(email);
	}

	
	
	
	
}
