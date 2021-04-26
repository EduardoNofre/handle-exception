package com.api.spring.handle.app.estudo.exceptions;

public class ClienteApiException extends Exception {

	private static final long serialVersionUID = 1L;

	public ClienteApiException(String message) {
        super(message);
    }

    public ClienteApiException(Throwable cause) {
        super(cause);
    }
}
