package com.example.entity;

import java.sql.Date;
import java.util.List;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "cartId")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	private long customerMobileNumber;
	private Date createdAt;

	@OneToMany(targetEntity = CartItem.class, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "cartId", referencedColumnName = "cartId")
//	@JsonManagedReference
	private List<CartItem> cartItems;

}
