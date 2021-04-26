package com.api.spring.handle.app.estudo.exceptions;

import static com.api.spring.handle.app.estudo.enums.protocoloInternalErrorCodesEnum.E413002;

public class EmailCaracterPontosQuantidadeException extends GenericException {

	private static final long serialVersionUID = 1L;

	public EmailCaracterPontosQuantidadeException() {
		super(E413002);
	}

	public EmailCaracterPontosQuantidadeException(String nomeCliente) {
		super(E413002, nomeCliente);
	}
	
	public EmailCaracterPontosQuantidadeException(String nomeCliente, long idCliente) {
		super(E413002, nomeCliente, idCliente);
	}
}
