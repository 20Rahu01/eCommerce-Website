package com.shopping.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shopping.Entities.ProductDetails;

public interface ProductRepositoy extends JpaRepository<ProductDetails, Integer> {

	@Query("select p from ProductDetails p where p.productName=?1")
	List<ProductDetails> getProductByName(String productName);

}
