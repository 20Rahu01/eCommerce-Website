package com.shopping.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.Entities.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer>{

}
