package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.Entities.OrderDetails;
import com.shopping.service.OrderService;


@RestController
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping("/bookOrder/{customerNo}/{cartId}")
	public ResponseEntity<OrderDetails> bookOrder(@PathVariable("productNo")int productNo, 
			@PathVariable("customerNo")int customerNo, 
			@PathVariable("cartId") int cart,@RequestBody OrderDetails orderDetails) {
		
		return new ResponseEntity<OrderDetails>
		(orderService.bookOrder(productNo,customerNo,cart,orderDetails),
				HttpStatus.CREATED);
	}
	
	@PostMapping("/cancelOrder/{orderId}")
	public String cancelOrder(@PathVariable("orderId") int orderId) {
		return orderService.cancelOrder(orderId);
	}
}
