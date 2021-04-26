package com.api.spring.handle.app.estudo.exceptions;

import static com.api.spring.handle.app.estudo.enums.protocoloInternalErrorCodesEnum.E413104;

public class ClienteNaoEncontradoDeleteException extends GenericException {

	private static final long serialVersionUID = 1L;

	public ClienteNaoEncontradoDeleteException() {
		super(E413104);
	}

	public ClienteNaoEncontradoDeleteException(String nomeCliente) {
		super(E413104, nomeCliente);
	}
	
	public ClienteNaoEncontradoDeleteException(String nomeCliente, long idCliente) {
		super(E413104, nomeCliente, idCliente);
	}
}
