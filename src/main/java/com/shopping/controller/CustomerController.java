package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.Entities.CustomerDetails;
import com.shopping.service.CustomerService;




@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	// Handler method to handle createCustomer request
	@PostMapping("/createCustomer")
	ResponseEntity<CustomerDetails> createPasenger(@RequestBody CustomerDetails customer){
		
		return new ResponseEntity<CustomerDetails>(customerService.
				createCustomer(customer),HttpStatus.CREATED);
	}
	
	// Handler method to handle deleteCustomer request
	@DeleteMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable("id") int id) {
		
		return customerService.deleteCustomer(id);
	}
	
	@PutMapping("updateCustomer/{id}")
	public ResponseEntity<CustomerDetails> updateCustomer(@PathVariable int id,
			@RequestBody CustomerDetails customer){
		
		return new ResponseEntity<CustomerDetails>(customerService.updateCustomer(id, customer),HttpStatus.OK);
	}
	
	@GetMapping("/getCustomerById/{id}")
	public CustomerDetails getCustomerById(@PathVariable("id") int id) {
		
		return customerService.getCustomerById(id);
	}
	
	@GetMapping("/getAllCustomer")
	public List<CustomerDetails> getAllCustomer(){
		
		return customerService.getAllCustomer();
	}
	
	@GetMapping("/getCustomer/{cname}/{email}/{password}")
	public ResponseEntity<CustomerDetails> findByCustomerNameAndEmailAndPassword(@PathVariable("cname") String customerName,
		@PathVariable("email") String email,@PathVariable("password") String password){
		
		return new ResponseEntity<CustomerDetails>(customerService.findByCustomerNameAndEmailAndPassword(customerName, email, password),HttpStatus.OK);
	}
	
	@GetMapping("/getCustomerByName/{name}")
	List<CustomerDetails> getCustomerByName(@PathVariable("name") String customerName){
		
		return customerService.getCustomerByName(customerName);
	}
	
//	@GetMapping("/getCustomerByEmail/{email}")
//	CustomerDetails getCustomerByEmail(@PathVariable("email") String email) {
//		
//		return customerService.getCustomerByEmail(email);
//	}
	
}
