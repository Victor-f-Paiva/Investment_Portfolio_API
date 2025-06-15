package com.paiva.investments.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class WalletNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public WalletNotFoundException(String msg) {
		super(msg);
	}

}
