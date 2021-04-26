package com.api.spring.handle.app.estudo.exceptions;

import static com.api.spring.handle.app.estudo.enums.protocoloInternalErrorCodesEnum.E413107;

public class ProdutoNaoEncontradoDeleteException  extends GenericException{

	private static final long serialVersionUID = 1L;

	public ProdutoNaoEncontradoDeleteException() {
		super(E413107);
	}

	public ProdutoNaoEncontradoDeleteException(String nomeCliente) {
		super(E413107, nomeCliente);
	}
	
	public ProdutoNaoEncontradoDeleteException(String nomeCliente, long idCliente) {
		super(E413107, nomeCliente, idCliente);
	}
}
