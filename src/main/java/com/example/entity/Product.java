package com.example.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	private long price;
	private int quantityInStock;
	private int reservedQuantity;
	private String brand;
	private Date createdAt;
	private Date updatedAt;

	@ManyToOne
	@JoinColumn(name = "categoryId")
//	This is another method to handel json parsing
//	@JsonBackReference
	private Category category;
	
	
	@OneToOne(mappedBy = "product")
	private CartItem cartItem;
	
	@OneToOne(mappedBy = "product")
	private OrderItem orderItem;

	public void assignTo(Category category) {
		this.category = category;

	}


}
