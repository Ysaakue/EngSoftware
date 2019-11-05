package agenda;

public class Contato {
	private String primeiroNome;
	private String ultimoNome;
	private String telefone;
	private String telefoneComercial;
	
	public Contato() {
	}
	
	public Contato(String primeiroNome, String telefone) {
		super();
		this.primeiroNome = primeiroNome;
		this.telefone = telefone;
	}

	public Contato(String primeiroNome, String ultimoNome, String telefone, String telefoneComercial) {
		super();
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
		this.telefone = telefone;
		this.telefoneComercial = telefoneComercial;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelefoneComercial() {
		return telefoneComercial;
	}

	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}
	
	
}
