package com.shopping.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.Entities.DeliveryDetails;
import com.shopping.Entities.OrderDetails;

public interface DeliveryRepository extends JpaRepository<DeliveryDetails, Integer>{

	DeliveryDetails save(OrderDetails orderDetails);

}
