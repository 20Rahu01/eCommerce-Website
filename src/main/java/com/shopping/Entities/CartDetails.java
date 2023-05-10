package com.shopping.Entities;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "cart_details")
public class CartDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int cartCustomerID;
	
	@Column(length=50)
	private String cartCustomerName;
	
	@Column(length=50)
	private String cartProductName;
	
	private int cartProductNoOfItems;
	
	private float cartEachProductPrice;
	
	private float cartTotal; 
	
	@Column(length=50)
	private String status;
	
	
	@OneToMany(mappedBy = "cartDetails",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("cartDetails")
	private List<OrderDetails> orderDetails;
	
	
	@ManyToOne
	@JsonIgnoreProperties("cartDetails")
	private ProductDetails productDetails;
	
	
	@OneToOne
	private CustomerDetails customerDetails;
}
