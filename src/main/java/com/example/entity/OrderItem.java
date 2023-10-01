
package com.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "itemId")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int itemId;
	private int quantity;
	private long unitPrice;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderId")
//	@JsonBackReference
	private OrderDB orderDB;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="productId")
	private Product product;
}