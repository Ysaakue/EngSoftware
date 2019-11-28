package domain.controller;

public class SaveException extends RuntimeException {
	  SaveException() {
		  super("Erro ao tentar salvar");
	  }
}
