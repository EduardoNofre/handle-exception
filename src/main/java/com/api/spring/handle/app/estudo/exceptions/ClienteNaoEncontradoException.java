package com.api.spring.handle.app.estudo.exceptions;

import static com.api.spring.handle.app.estudo.enums.protocoloInternalErrorCodesEnum.E413103;
import static com.api.spring.handle.app.estudo.enums.protocoloInternalErrorCodesEnum.E413104;

public class ClienteNaoEncontradoException extends GenericException {

	private static final long serialVersionUID = 1L;

	public ClienteNaoEncontradoException() {
		super(E413103);
	}

	public ClienteNaoEncontradoException(String nomeCliente) {
		super(E413103, nomeCliente);
	}

	public ClienteNaoEncontradoException(String nomeCliente, long idCliente) {
		super(E413104, nomeCliente, idCliente);
	}

}
