package com.shopping.service;

import java.util.List;


import com.shopping.Entities.CartDetails;
public interface CartService {

	
	CartDetails addingCart(int customerId,int productNo,CartDetails cartDetails);
	CartDetails getCartDetailsById(int id);
	List<CartDetails> getAllCartDetails();
	String deleteCartDetails(int id);
	CartDetails updateCartDetails(int id,CartDetails cartDetails);
}
