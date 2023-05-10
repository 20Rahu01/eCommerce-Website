package com.shopping.Entities;

import java.time.LocalTime;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
public class DeliveryDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalTime departureTime;
	private LocalTime arrivalTime;
	
	@Column(length =50)
	private String deliveryCustomerName;
	
	@Column(length =10)
	private String deliveryCustomerPhno;
	
	@Column(length =200)
	private String customerAddress;
	
	@Column(length=50)
	private String status;
	
	@OneToOne(mappedBy = "deliveryDetails")
	@JsonIgnoreProperties("deliveryDetails")
	private OrderDetails orderDetails;
	

	@OneToOne
	private CustomerDetails customerDetails;
}
