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
	
	public Stock() {}

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
