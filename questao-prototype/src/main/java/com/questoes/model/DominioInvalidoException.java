package com.questoes.model;

public class DominioInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DominioInvalidoException(String mensagem) {
		super(mensagem);
	}

}
