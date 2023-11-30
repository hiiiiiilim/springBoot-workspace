package com.kh.spring.cafe.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cafe {
	
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE, generator = "cafe_sequence")
	@SequenceGenerator(name="cafe_sequence", sequenceName = "cafe_sequence", allocationSize = 1)
	private Long cafeId;
	private String name;
	private String location;
	private String openingHours;
}
