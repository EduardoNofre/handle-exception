package com.api.spring.handle.app.estudo.exceptions;

import static com.api.spring.handle.app.estudo.enums.protocoloInternalErrorCodesEnum.E413000;

public class EmailCaracterArrobaException extends GenericException {

	private static final long serialVersionUID = 1L;

	public EmailCaracterArrobaException() {
		super(E413000);
	}

	public EmailCaracterArrobaException(String nomeCliente) {
		super(E413000, nomeCliente);
	}
	
	public EmailCaracterArrobaException(String nomeCliente, long idCliente) {
		super(E413000, nomeCliente, idCliente);
	}
}
