package com.paiva.investments.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

/**
 * Entity that represents an asset in the system.
 * Contains asset details and relationships with enum type - STOCK or REAL_STATE_FUND.
 */
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
	@JsonBackReference
	private Wallet wallet;
	
	/**
	 * Default constructor required by JPA.
	 */
	public Asset() {}

	/**
	 * Creates an asset with the specified name, value, purchase date and asset type.
	 * 
	 * @param name the name of the asset
	 * @param value the value of the asset
	 * @param purchaseDate the purchase date of the asset
	 * @param type the type of the asset - stock or real state fund
	 */
	public Asset(String name, double value, LocalDate purchaseDate, AssetType type) {
		this.name = name;
		this.value = value;
		this.purchaseDate = purchaseDate;
		this.type = type;
	}
	
}
