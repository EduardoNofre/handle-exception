package com.api.spring.handle.app.estudo.exceptions;

import static com.api.spring.handle.app.estudo.enums.protocoloInternalErrorCodesEnum.E413106;

public class ProdutoNaoEncontradoException extends GenericException{

	private static final long serialVersionUID = 1L;

	public ProdutoNaoEncontradoException() {
		super(E413106);
	}

	public ProdutoNaoEncontradoException(String nomeCliente) {
		super(E413106, nomeCliente);
	}
	
	public ProdutoNaoEncontradoException(String nomeCliente, long idCliente) {
		super(E413106, nomeCliente, idCliente);
	}
}
