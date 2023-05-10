package com.shopping.service;

import java.util.List;
import com.shopping.Entities.ProductDetails;

public interface ProductService {

	ProductDetails createProduct(int productNo,ProductDetails product);
	String deleteProduct(int id);
	ProductDetails updateProduct(int id,ProductDetails product);
	ProductDetails getProductById(int id);
	List<ProductDetails> getAllProduct();
	List<ProductDetails> getProductByName(String productName);
}
