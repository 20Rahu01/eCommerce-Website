package com.shopping.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shopping.Entities.CustomerDetails;
@Repository
public interface CustomerRepositoy extends JpaRepository<CustomerDetails, Integer> {

	CustomerDetails findByCustomerNameAndEmailAndPassword(String customerName, String email, String password);

	@Query("select c from CustomerDetails c where c.customerName=?1")
	List<CustomerDetails> getCustomerByName(String customerName);

	@Query("select c from CustomerDetails c where c.email=:email")
	CustomerDetails getCustomerByEmail(String email);

	
}
