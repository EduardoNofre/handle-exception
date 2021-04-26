package com.api.spring.handle.app.estudo.exceptions;

import com.api.spring.handle.app.estudo.enums.protocoloInternalErrorCodesEnum;

public abstract class GenericException extends CodigoDeErroException {

	private static final long serialVersionUID = 1L;

	protected GenericException(protocoloInternalErrorCodesEnum errorcode) {
		super(errorcode);
	}

	protected GenericException(protocoloInternalErrorCodesEnum errorcode, Object... args) {
		super(errorcode, args);
	}
}
