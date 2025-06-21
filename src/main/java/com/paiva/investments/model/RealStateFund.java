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

	public RealStateFund() {}
	
	public RealStateFund(String name, double value, double dividends) {
		super(name, value, LocalDate.now(), AssetType.REAL_STATE_FUND);
		this.dividends = dividends;
	}

}
