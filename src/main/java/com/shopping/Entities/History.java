package com.shopping.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class History {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	@Column(length =50)
	private String historyCustomerName;
	
	private String historyDeliveryDate;
	
	@Column(length =50)
	private String hisoryAddress;
	
	private int historyOrderId;
	
	
	@OneToOne
	private CustomerDetails customerDetails;
	
	@OneToOne
	private OrderDetails orderDetails;
	
}
