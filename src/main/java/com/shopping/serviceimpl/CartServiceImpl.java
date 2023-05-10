package com.shopping.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.Entities.CartDetails;
import com.shopping.Entities.CustomerDetails;
import com.shopping.Entities.OrderDetails;
import com.shopping.Entities.ProductDetails;
import com.shopping.exception.ResourceNotFoundException;
import com.shopping.repositories.CartDetailsRepository;
import com.shopping.repositories.CustomerRepositoy;
import com.shopping.repositories.OrderDetailsRepository;
import com.shopping.repositories.ProductRepositoy;
import com.shopping.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	
	@Autowired 
	private CartDetailsRepository cartDetailsRepository;
	
	@Autowired 
	private ProductRepositoy productRepositoy;
	
	@Autowired 
	private CustomerRepositoy customerRepositoy;
	
	@Autowired 
	private OrderDetailsRepository orderDetailsRepository;
	
	@Override
	public CartDetails addingCart(int customerId, int productNo, CartDetails cartDetails) {
		
		ProductDetails product = productRepositoy.findById(productNo).get();
		CustomerDetails customer = customerRepositoy.findById(customerId).get();
		
		int total_product= product.getTotalAmountPresent()-cartDetails.getCartProductNoOfItems();
		product.setTotalAmountPresent(total_product);// updating product after deduction
		
		cartDetails.setCartTotal(product.getProductPrice()*(cartDetails.getCartProductNoOfItems()));
		cartDetails.setCustomerDetails(customer);
		cartDetails.setProductDetails(product);
		cartDetails.setCartProductNoOfItems(cartDetails.getCartProductNoOfItems());
		List<OrderDetails> orderList=cartDetails.getOrderDetails();
		cartDetails.setOrderDetails(orderList);
		
		OrderDetails order=null;
		if(!orderList.isEmpty()) {
			for(OrderDetails o:orderList) {
				
				order=o;
				if(o!=null) {
					order.setCartDetails(cartDetails);
					order.setStatus("Confirmed");
				}
				orderDetailsRepository.save(order);
			}
		}
		cartDetails.setStatus("Booked");
		CartDetails cart= cartDetailsRepository.save(cartDetails);
		
		return cart;
		
		
	}
	

	@Override
	public CartDetails getCartDetailsById(int id) {
		CartDetails cartById = cartDetailsRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("CartDetails", "id", id));
		
		return cartById;
	}

	@Override
	public List<CartDetails> getAllCartDetails() {
		List<CartDetails> cartAll = cartDetailsRepository.findAll();
		return cartAll;
	}

	@Override
	public String deleteCartDetails(int id) {
		String message=null;
		Optional<CartDetails> cart = cartDetailsRepository.findById(id);
		if(cart.isPresent()) {
			cartDetailsRepository.deleteById(id);
			message=new String("Cart record deleted successfully!!");
		}
		else {
			throw new ResourceNotFoundException("CartDetails","id",id);
		}
		return message;
	}

	@Override
	public CartDetails updateCartDetails(int id, CartDetails cartDetails) {
		CartDetails existingCartDetails = cartDetailsRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("CartDetails", "id", id));

		existingCartDetails.setCartCustomerID(cartDetails.getCartCustomerID());
		existingCartDetails.setCartCustomerName(cartDetails.getCartCustomerName());
		existingCartDetails.setCartEachProductPrice(cartDetails.getCartEachProductPrice());
		existingCartDetails.setCartProductName(cartDetails.getCartProductName());
		existingCartDetails.setCartProductNoOfItems(cartDetails.getCartProductNoOfItems());
		existingCartDetails.setCartTotal(cartDetails.getCartTotal());
		
		cartDetailsRepository.save(existingCartDetails);
		return existingCartDetails;
	}

	

	
}
