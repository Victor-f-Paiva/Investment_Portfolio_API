package com.paiva.investments.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class Asset {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private double value;
	private LocalDate purchaseDate;
	
	@Enumerated(EnumType.STRING)
	private AssetType type;
	
	@ManyToOne
	private Wallet wallet;
	
	public Asset() {}

	public Asset(String name, double value, LocalDate purchaseDate, AssetType type) {
		this.name = name;
		this.value = value;
		this.purchaseDate = purchaseDate;
		this.type = type;
	}
	
}
