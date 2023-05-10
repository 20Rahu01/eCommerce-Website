package com.shopping.Entities;



import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="order_details")
public class OrderDetails {

	@Id
	@GenericGenerator(name = "order_id", strategy = "com.shopping.Entities.OrderIdGeneration")
	@GeneratedValue(generator ="order_id")
	private int orderId;
	
	@Column(length =2)
	private int noOfItems;
	
	@Column(length =50)
	private String nameOfItem;
	
	@Column(length =10)
	private double totalBill;
	
	@Column(length=50)
	private String status;
	
	@OneToOne
	@JoinColumn(name = "delivery_details")
	@JsonIgnoreProperties("orderDetails")
	private DeliveryDetails deliveryDetails;
	
//	@ManyToOne(cascade = CascadeType.PERSIST)
//	@JsonIgnoreProperties("passengers")
//	TicketDetails ticketDetails;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("orderDetails")
	private CartDetails cartDetails;
	
	
	@OneToOne
	private ProductDetails productDetails;
	
	@OneToOne
	private CustomerDetails customerDetails;
}
