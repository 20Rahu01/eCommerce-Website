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

import com.shopping.Entities.ProductDetails;
import com.shopping.service.ProductService;


@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	// Handler method to handle createProduct request
	@PostMapping("/createProduct")
	ResponseEntity<ProductDetails> createProduct(@RequestBody ProductDetails product){
		
		return new ResponseEntity<ProductDetails>(productService.
				createProduct( 0, product),HttpStatus.CREATED);
	}
	
	// Handler method to handle deleteProduct request
	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable("id") int id) {
		
		return productService.deleteProduct(id);
	}
	
	@PutMapping("updateProduct/{id}")
	public ResponseEntity<ProductDetails> updateProduct(@PathVariable int id,
			@RequestBody ProductDetails product){
		
		return new ResponseEntity<ProductDetails>(productService.updateProduct(id, product),HttpStatus.OK);
	}
	
	@GetMapping("/getProductById/{id}")
	public ProductDetails getProductById(@PathVariable("id") int id) {
		
		return productService.getProductById(id);
	}
	
	@GetMapping("/getAllProduct")
	public List<ProductDetails> getAllProduct(){
		
		return productService.getAllProduct();
	}
	
	@GetMapping("/getProductByName/{name}")
	List<ProductDetails> getProductByName(@PathVariable("name") String productName){
		
		return productService.getProductByName(productName);
	}
}
