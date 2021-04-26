package com.api.spring.handle.app.estudo.exceptions;

import static com.api.spring.handle.app.estudo.enums.protocoloInternalErrorCodesEnum.E413108;

public class ProdutoNaoEncontradoAtualizarException extends GenericException{

	private static final long serialVersionUID = 1L;

	public ProdutoNaoEncontradoAtualizarException() {
		super(E413108);
	}

	public ProdutoNaoEncontradoAtualizarException(String nomeCliente) {
		super(E413108, nomeCliente);
	}
	
	public ProdutoNaoEncontradoAtualizarException(String nomeCliente, long idCliente) {
		super(E413108, nomeCliente, idCliente);
	}
}
