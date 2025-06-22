package com.paiva.investments.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when a asset is not found in the database.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class AssetNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	/**
	 * Exception thrown when an asset is not found.
	 *
	 * @param message the detail message explaining the exception
	 */
	public AssetNotFoundException(String message) {
		super(message);
	}

}
