package com.shopping.service;

import com.shopping.Entities.OrderDetails;

public interface OrderService {

	OrderDetails bookOrder(int productNo, int customerId, int cart,OrderDetails orderDetails);
	String cancelOrder(int orderId);
}
