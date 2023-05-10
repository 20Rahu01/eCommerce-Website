package com.shopping.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.Entities.CartDetails;

public interface CartDetailsRepository extends JpaRepository<CartDetails, Integer>{

}
