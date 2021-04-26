package com.api.spring.handle.app.estudo.exceptions;

import static com.api.spring.handle.app.estudo.enums.protocoloInternalErrorCodesEnum.E413001;

public class EmailCaracterPontoException extends GenericException {

	private static final long serialVersionUID = 1L;

	public EmailCaracterPontoException() {
		super(E413001);
	}

	public EmailCaracterPontoException(String nomeCliente) {
		super(E413001, nomeCliente);
	}
	
	public EmailCaracterPontoException(String nomeCliente, long idCliente) {
		super(E413001, nomeCliente, idCliente);
	}
}
