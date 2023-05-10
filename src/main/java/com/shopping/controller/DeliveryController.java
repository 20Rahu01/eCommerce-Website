package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.Entities.DeliveryDetails;
import com.shopping.service.DeliveryService;

@RestController
public class DeliveryController {

	@Autowired
	private DeliveryService deliveryService;
	
	@PostMapping("/outForDelivery/{orderNo}")
	public ResponseEntity<DeliveryDetails> outForDelivery(@PathVariable("ordrerNo")int orderNo, 
			@PathVariable("productNo")int productNo, 
			@PathVariable("customerNo")int customerId, 
			@RequestBody DeliveryDetails deliveryDetails) {
		
		//int productNo, int customerId, int orderNo, DeliveryDetails deliveryDetails
		
		return new ResponseEntity<DeliveryDetails>
		(deliveryService.outForDelivery(productNo,customerId, orderNo, deliveryDetails),HttpStatus.CREATED);
	}
}
