package com.kh.spring.shop.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
@Table(name="products")
@SequenceGenerator(name = "products_sequence", 
sequenceName="products_sequence",
allocationSize = 1)
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_sequence")
	private Long product_id;
	private String product_name;
	private String category;
	private Double price;
	private Integer stock_quantity;
	private String description;
}


