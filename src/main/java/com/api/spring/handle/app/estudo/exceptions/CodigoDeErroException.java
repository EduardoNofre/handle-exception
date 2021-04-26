package com.api.spring.handle.app.estudo.exceptions;

import com.api.spring.handle.app.estudo.enums.protocoloInternalErrorCodesEnum;

public abstract class CodigoDeErroException extends Exception  {
	
	private static final long serialVersionUID = 1L;
	
	protected protocoloInternalErrorCodesEnum errorcode;

    protected CodigoDeErroException(protocoloInternalErrorCodesEnum errorcode) {
        super(errorcode.getMessage());
        this.errorcode = errorcode;
    }

    protected CodigoDeErroException(protocoloInternalErrorCodesEnum errorcode, Object... args) {
        super(String.format(errorcode.getMessage(), args));
        this.errorcode = errorcode;
    }

    public protocoloInternalErrorCodesEnum getErrorcode() {
        return errorcode;
    }
}
