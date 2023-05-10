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
import org.springframework.web.bind.annotation.RestController;

import com.shopping.Entities.CartDetails;
import com.shopping.service.CartService;

@RestController
public class CartController {

	@Autowired
	private CartService cartService;
		
	@PostMapping("/addingCart/customerId/productNo")
	ResponseEntity<CartDetails> createCart(@PathVariable("customerId")int customerId , 
			@PathVariable("productNo") int productNo,@RequestBody CartDetails cart){
		
		return new ResponseEntity<CartDetails>(cartService.
				addingCart(customerId,productNo,cart),HttpStatus.CREATED);

	}
	
	// Handler method to handle deleteProduct request
	@DeleteMapping("/deleteCart/{id}")
	public String deleteCart(@PathVariable("id") int id) {
		
		return cartService.deleteCartDetails(id);
	}
	
	@PutMapping("updateCart/{id}")
	public ResponseEntity<CartDetails> updateCart(@PathVariable int id,
			@RequestBody CartDetails cart){
		
		return new ResponseEntity<CartDetails>(cartService.updateCartDetails(id, cart),HttpStatus.OK);
	}
	
	@GetMapping("/getCartById/{id}")
	public CartDetails getCustomerById(@PathVariable("id") int id) {
		
		return cartService.getCartDetailsById(id);
	}
	
	@GetMapping("/getAllCart")
	public List<CartDetails> getAllart(){
		
		return cartService.getAllCartDetails();
	}
	
	
	
}
