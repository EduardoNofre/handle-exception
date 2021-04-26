package com.api.spring.handle.app.estudo.exceptions;

import static com.api.spring.handle.app.estudo.enums.protocoloInternalErrorCodesEnum.E413105;

public class ClienteNaoEncontradoAtualizarException extends GenericException {

	private static final long serialVersionUID = 1L;

	public ClienteNaoEncontradoAtualizarException() {
		super(E413105);
	}

	public ClienteNaoEncontradoAtualizarException(String nomeCliente) {
		super(E413105, nomeCliente);
	}
	
	public ClienteNaoEncontradoAtualizarException(String nomeCliente, long idCliente) {
		super(E413105, nomeCliente, idCliente);
	}
}
