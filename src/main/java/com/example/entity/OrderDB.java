package com.example.entity;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "orderId")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orderdb")
public class OrderDB {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;

	@Column(name = "customer_mobile_number")
	private long customerMobileNumber;
	
	private Date orderDate;
	private String status;
	private long totalAmount;
	private String shoppingAddress;
	@OneToMany(targetEntity = OrderItem.class, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "orderId", referencedColumnName = "orderId")
//	@JsonManagedReference
	private List<OrderItem> orderItems;

	@OneToOne(mappedBy = "orderDB")
	private Payment payment;
}
