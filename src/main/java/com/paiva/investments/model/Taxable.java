package com.paiva.investments.model;

/**
 * Interface that defines taxable assets.
 * 
 * <p>
 * Any asset that implements this interface must provide
 * an implementation for tax calculation.
 * </p>
 */
public interface Taxable {
	
	/**
     * Calculates the tax for the asset.
     *
     * @return the calculated tax amount
     */
	double calculateTax();

}
