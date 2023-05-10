package com.shopping.service;

import com.shopping.Entities.DeliveryDetails;

public interface DeliveryService {

	DeliveryDetails outForDelivery(int productNo,int customerId,int orderNo,DeliveryDetails deliveryDetails);
}
