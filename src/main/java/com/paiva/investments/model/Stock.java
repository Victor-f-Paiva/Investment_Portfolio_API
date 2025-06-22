package com.paiva.investments.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity that represents an stock in the system.
 * Contains asset details - name, value and dividends.
 */
@Entity
@Getter @Setter 
public class Stock extends Asset implements Taxable{
	
	private double dividends;
	
	/**
	 * Default constructor required by JPA.
	 */
	public Stock() {}

	/**
	 * Creates a asset with type Stock with the specified name, value and dividends
	 * 
	 * @param name the name of the asset
	 * @param value the value of the asset
	 * @param dividends the dividend yield
	 */
	public Stock(String name, double value, double dividends) {
		super(name, value, LocalDate.now(), AssetType.STOCK);
		this.dividends = dividends;
	}

	/**
	 * Calculates the tax on stock dividends
	 * The tax rate applied is 15%
	 * 
	 * @return the amount of tax to be paid
	 */
	@Override
	public double calculateTax() {
		return dividends * 0.15; // tax = 15%
	}

}
