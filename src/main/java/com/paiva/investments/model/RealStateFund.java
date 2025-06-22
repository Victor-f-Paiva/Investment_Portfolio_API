package com.paiva.investments.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity that represents an Real state fund in the system.
 * Contains asset details - name, value and dividends.
 */
@Entity
@Getter @Setter 
public class RealStateFund extends Asset{
	
	private double dividends;

	/**
	 * Default constructor required by JPA.
	 */
	public RealStateFund() {}
	
	/**
	 * Creates a asset with type Real Estate Fund with the specified name, value and dividends
	 * 
	 * @param name the name of the asset
	 * @param value the value of the asset
	 * @param dividends the dividend yield
	 */
	public RealStateFund(String name, double value, double dividends) {
		super(name, value, LocalDate.now(), AssetType.REAL_STATE_FUND);
		this.dividends = dividends;
	}

}
