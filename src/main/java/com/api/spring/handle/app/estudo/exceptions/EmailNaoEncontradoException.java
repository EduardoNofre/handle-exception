package com.api.spring.handle.app.estudo.exceptions;

import static com.api.spring.handle.app.estudo.enums.protocoloInternalErrorCodesEnum.E413003;

public class EmailNaoEncontradoException  extends GenericException {
	
	private static final long serialVersionUID = 1L;

	public EmailNaoEncontradoException() {
		super(E413003);
	}

	public EmailNaoEncontradoException(String nomeCliente) {
		super(E413003, nomeCliente);
	}
	
	public EmailNaoEncontradoException(String nomeCliente, long idCliente) {
		super(E413003, nomeCliente, idCliente);
	}

}
