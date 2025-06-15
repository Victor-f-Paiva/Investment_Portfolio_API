package com.paiva.investments.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter 
public class Stock extends Asset implements Taxable{
	
	private double dividends;
	
	public Stock() {}

	public Stock(String name, double value, double dividends) {
		super(name, value, LocalDate.now(), AssetType.STOCK);
		this.dividends = dividends;
	}

	@Override
	public double calculateTax() {
		return dividends * 0.15; // tax = 15%
	}

}
