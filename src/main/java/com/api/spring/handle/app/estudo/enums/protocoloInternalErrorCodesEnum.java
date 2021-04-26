package com.api.spring.handle.app.estudo.enums;

public enum protocoloInternalErrorCodesEnum {

		//400
	 	E400000("400", "000", "N\u00famero do telefone informado n\u00e3o \u00e9 valido: %s"),
	    E400001("400", "001", "N\u00famero do telefone n\u00e3o pode ser vazio"),
	    E400002("400", "002", "O tipo da pessoa (F\u00edsica/Jur\u00eddica) n\u00e3o \u00e9 v\u00e1lido para o c\u00f3digo informado: %s"),
	    E400003("400", "003", "Erro ao gerar a chave de acesso para a Cliente "),
	    E400004("400", "004", "Os dados obrigat\u00f3rios n\u00e3o foram informados"),
	    E400005("400", "005", "O e-mail n\u00e3o pode ser vazio"),
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
	    E413003("413", "003", "E-mail não encontrado."),
	    E413004("413", "004", "Telefone j\u00e1 cadastrado"),
	    E413005("413", "005", "CPF/CNPJ j\u00e1 cadastrado"),
	    E413006("413", "006", "O telefone informado \u00e9 diferente do registro no Clienteto"),
	    E413007("413", "007", "O CPF/CNPJ informado \u00e9 diferente do registro no Clienteto"),
	    E413100("413", "100", "Clienteto n\u00e3o encontrado: %s"),
	    E413101("413", "101", "Clienteto do remetente n\u00e3o encontrado: %s"),
	    E413102("413", "102", "Cliente nenhum cliente encontrado: %s"),
	    E413103("413", "103", "Cliente n\u00e3o encontrada pelo id: %s"),
	    E413104("413", "104", "Cliente n\u00e3o encontrada pelo id para ser deletado: %s"),
	    E413105("413", "105", "Cliente n\\u00e3o encontrado pelo id para ser atualizado: %s"),
	    E413106("413", "106", "Produto n\\u00e3o encontrada pelo id: %s\""),
	    E413107("413", "107", "Produto n\u00e3o encontrada pelo id para ser deletado: %s"),
	    E413108("413", "108", "Produto n\\u00e3o encontrado pelo id para ser atualizado: %s"),
	    E413109("413", "109", "A Cliente informada n\u00e3o possui endere\u00e7o cadastrado na API da Cliente "),
	    //417
	    E417000("417", "000", "Saldo insuficiente para realizar a opera\u00e7\u00e3o"),
	    //418
	    E418000("418", "000", "O valor %s excede o limite por opera\u00e7\u00e3o de transfer\u00eancia (%s)"),
	    E418001("418", "001", "O valor %s excede o limite di\u00e1rio (%s)"),
	    //419
	    E419000("419", "000", "O valor %s est\u00e1 abaixo do valor minimo de recarga (%s)"),
	    E419001("419", "001", "O valor %s excede o valor m\u00e1ximo de recargas no m\u00e9s (%2), valor total de recargas no m\u00eas at\u00e9 o momento: %s"),
	    //440
	    E440000("440", "000", "Erro ao buscar os dados para enriquecimento do Clienteto."),
	    E440001("440", "001", "Sem informa\u00e7\u00e3o do Clienteto para enriquecimento dos dados."),
	    //441
	    E441000("441", "000", "Erro ao buscar os dados do Clienteto no cliente do bot."),
	    E441001("441", "001", "O Clienteto n\u00e3o foi encontrado no cliente do bot."),
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
