package com.shopping.Entities;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="product_details")
public class ProductDetails {

	@Id
	@GenericGenerator(name = "product_no", strategy = "com.shopping.Entities.ProductIdGeneration")
	@GeneratedValue(generator ="product_no")
	private int productNo;
	
	@Column(name = "Category Name", length = 50)
	private String category;
	
	@Column(name = "Product Name", length = 50)
	private String productName;
	
	@Column(name = "Product Orginal Price",length = 10)
	private float productOrginalPrice;
	
	@Column(name = "Discount",length = 2)
	private int discount;
	
	@Column(name = "Product Price",length = 10)
	private float productPrice;
	
	@Column(name = "Total Amount Present",length = 10)
	private int totalAmountPresent;
	
	@Column(name = "Ratings",length = 1)
	private float ratings;
	
	@Column(name = "Total Purchase",length = 10)
	private int totalPurchase;
	
	@OneToMany(mappedBy = "productDetails")	
	private List<CartDetails> cartDetails;
	

}
