package com.service;

@SuppressWarnings("serial")
public class SaveException extends RuntimeException {
	  SaveException() {
		  super("Erro ao tentar salvar");
	  }
}
