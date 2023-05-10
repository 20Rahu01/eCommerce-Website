package com.shopping.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.Entities.DeliveryDetails;
import com.shopping.Entities.OrderDetails;
import com.shopping.repositories.DeliveryRepository;
import com.shopping.repositories.OrderDetailsRepository;
import com.shopping.service.DeliveryService;

@Service
public class DeliveryServiceImpl implements DeliveryService{

	@Autowired
	private  OrderDetailsRepository orderDetailsRepository;
	
	@Autowired
	private DeliveryRepository deliveryRepository;
	

	@Override
	public DeliveryDetails outForDelivery(int productNo, int customerId, int orderNo, DeliveryDetails deliveryDetails) {
		
		OrderDetails orderDetails = orderDetailsRepository.findById(orderNo).get();
		deliveryDetails.setStatus("Product Deliveried!!");

		DeliveryDetails bookedDelivery= deliveryRepository.save(orderDetails);
		
		return bookedDelivery;
		
	}
}
