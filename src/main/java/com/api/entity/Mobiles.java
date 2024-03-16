package com.api.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mobiles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mobileId;

	private String mobileName;

	private Double mobilePrice;

	private Integer employeeId;

	transient List<simCards> sims;

}
