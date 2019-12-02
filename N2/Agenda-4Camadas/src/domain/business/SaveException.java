package domain.business;

@SuppressWarnings("serial")
public class SaveException extends RuntimeException {
	  SaveException() {
		  super("Erro ao tentar salvar");
	  }
}
