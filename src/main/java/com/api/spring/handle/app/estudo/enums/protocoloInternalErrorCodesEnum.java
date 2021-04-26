package com.api.spring.handle.app.estudo.enums;

public enum protocoloInternalErrorCodesEnum {

		//400
	    E400000("400", "000", "N\u00famero do telefone informado n\u00e3o \u00e9 valido: %s"),

	    //404
	    E404000("404", "000", "Descrição não encontrado: %s"),
	    E404001("404", "001", "PlayLista não encontrada: %s"),
	    E404002("404", "002", "Tag não encontrada: %s"),
	    E404003("404", "003", "Thumbnail não encontrada: %s"),
	    E404004("404", "004", "O titulo não encontrada: %s"),
	    E404005("404", "005", "Video não encontrado: %s"),
	    //413
	    E413000("413", "000", "E-mail não tem o caracter @ arroba"),
	    E413001("413", "001", "E-mail não tem o caracter . ponto"),
	    E413002("413", "002", "E-mail não tem a quantidade caracter . ponto"), 
	    //417
	    E417000("417", "000", "Saldo insuficiente para realizar a opera\u00e7\u00e3o"),
	    //418
	    E418000("418", "000", "O valor %s excede o limite "),
	    //419
	    E419000("419", "000", "O valor %s est\u00e1 abaixo do valor minimo de recarga (%s)"),
	    //440
	    E440000("440", "000", "Erro ao buscar os dados "),
	    E440001("440", "001", "Sem informa\u00e7\u00e3o do Cliente"),
	    //441
	    E441000("441", "000", "Erro ao buscar os dados"),
	    E441001("441", "001", "O Clienteto n\u00e3o foi encontrado no cliente"),
	    //442
	    E442000("442", "000", "Erro na integra\u00e7\u00e3o com o cliente de e-mail."),
	    E442001("442", "001", "O destinat\u00e1rio do e-mail n\u00e3o foi informado."),
	    E442002("442", "002", "O texto da mensagem no corpo do e-mail n\u00e3o foi informado."),
	    E442003("442", "003", "O texto do assunto do e-mail n\u00e3o foi informado."),
	    E442004("442", "004", "O anexo n\u00e3o foi informado."),
	    //460
	    E460000("460", "000", "Erro gen\u00e9rico da Cliente ."),
	    //500
	    E500000("500", "000", "Erro interno sem causa mapeada");

	    private final String errorTypeCode;
	    private final String errorcode;
	    private final String message;

	    protocoloInternalErrorCodesEnum(String errorTypeCode, String errorcode, String message) {
	        this.errorTypeCode = errorTypeCode;
	        this.errorcode = errorcode;
	        this.message = message;
	    }

	    public String getValue() {
	        return this.name();
	    }

	    public String getErrorcode() {
	        return String.format("%s.%s", errorTypeCode, errorcode);
	    }

	    public String getMessage() {
	        return message;
	    }

	    @Override
	    public String toString() {
	        return String.format("C\u00f3digo da falha: %s = %s.", getErrorcode(), getMessage());
	    }
}
