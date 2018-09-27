package com.smart.blind.gadget.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5086630042150537373L;

	public ResourceNotFoundException(String string) {
		super(string);
	}

	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
