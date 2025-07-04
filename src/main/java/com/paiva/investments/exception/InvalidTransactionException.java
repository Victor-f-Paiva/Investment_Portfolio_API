package com.paiva.investments.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when a transaction is invalid.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidTransactionException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	/**
	 * Exception thrown when a transaction is invalid.
	 *
	 * @param msg the detail message explaining the exception
	 */
	public InvalidTransactionException(String msg) {
		super(msg);
	}

}
