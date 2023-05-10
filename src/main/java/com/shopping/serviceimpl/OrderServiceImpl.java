package com.shopping.serviceimpl;


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
import com.shopping.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService{

	
	@Autowired
	private  OrderDetailsRepository orderDetailsRepository;
	
	@Autowired
	private ProductRepositoy productRepositoy;
	
	@Autowired
	private CartDetailsRepository cartDetailsRepository;
	
	@Autowired
	private CustomerRepositoy customerRepositoy;
	
	@Override
	public OrderDetails bookOrder(int productNo, int customerId,int cart, OrderDetails orderDetails) {
		ProductDetails productDetails = productRepositoy.findById(productNo).get();
		CartDetails cartDetails = cartDetailsRepository.findById(cart).get();
		CustomerDetails customerDetails= customerRepositoy.findById(customerId).get();
		
		
		int total_product= (productDetails.getTotalAmountPresent()-cartDetails.getCartProductNoOfItems());
		productDetails.setTotalAmountPresent(total_product);
		
		orderDetails.setCustomerDetails(customerDetails);
		orderDetails.setProductDetails(productDetails);
		CartDetails cartList=orderDetails.getCartDetails();
		orderDetails.setCartDetails(cartList);
		orderDetails.setNoOfItems(cartDetails.getCartProductNoOfItems());
		orderDetails.setNameOfItem(cartDetails.getCartProductName());
		orderDetails.setTotalBill(orderDetails.getNoOfItems()*productDetails.getProductOrginalPrice());
		
		
		orderDetails.setStatus("Booked");

		OrderDetails bookedOrder= orderDetailsRepository.save(orderDetails);
		
		return bookedOrder;
	}

	@Override
	public String cancelOrder(int orderId) {
		String message=null;
		Optional<OrderDetails> opOrder=orderDetailsRepository.findById(orderId);
		if(opOrder.isPresent()) {
			//update the available seat
			int nop=opOrder.get().getNoOfItems();
			OrderDetails odetails=opOrder.get();
			odetails.getProductDetails().setTotalAmountPresent(odetails.getProductDetails().getTotalAmountPresent()+nop);  //98+2
			odetails.setStatus("Cancelled");
			
			CartDetails c=odetails.getCartDetails();
			
				cartDetailsRepository.delete(c);
			
			orderDetailsRepository.save(odetails);
			message="Your order has cancelled";
		}
		else
			throw new ResourceNotFoundException("OrderDetails", "id", orderId);
		return message;
	}

	
	
}
