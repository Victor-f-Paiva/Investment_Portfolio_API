package com.paiva.investments.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when a wallet is not found in the database.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class WalletNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	/**
	 * Exception thrown when a wallet is not found in the system.
	 *
	 * @param msg the detail message explaining the exception
	 */
	public WalletNotFoundException(String msg) {
		super(msg);
	}

}
