package com.shopping.Entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "Users")
public class CustomerDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	
	@Column(name = "customer_name", length = 30)
	private String customerName;
	
	@Column(length = 15, unique = true)
	private String password;
	
	private int age;
	
	@Column(length = 15)
	private String gender;
	
	@Column(length = 60, unique = true)
	private String email;
	
	@Column(length = 10, unique = true)
	private String phno;
	
	@Column(length = 200)
	private String address;

	

}
