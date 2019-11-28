package domain;

import java.util.Scanner;

import domain.controller.ContactController;
import domain.controller.ContactGroupController;
import domain.view.Layouts;

public class App {
	ContactGroupController grupoController;
	ContactController contatoController;
	
	private App() {
		this.contatoController = new ContactController();
		this.grupoController = new ContactGroupController();
	}
	
	public static void main(String[] args) {
		App app = new App();
		Scanner sc = new Scanner(System.in);
		int opcao = 0;
		String notice = "";
		do{
			opcao = Layouts.menu(notice);
			notice = app.processa(opcao);
		}while(opcao!=0);
		sc.close();
		System.out.println("\n\n -- SISTEMA ENCERRADO --\n");
	}
	
	public String processa(int opcao) {
		String retorno = "";
		switch(opcao) {
			case 0:
				Layouts.clear();
				break;
			case 1:
				Layouts.clear();
				retorno = contatoController.create();
				break;
			case 2:
				Layouts.clear();
				retorno = grupoController.create();
				break;
			case 3:
				Layouts.clear();
				contatoController.index();
				Layouts.pressToContinue();
				break;
			case 4:
				Layouts.clear();
				grupoController.index();
				Layouts.pressToContinue();
				break;
			default:
				System.out.println("Invalid option");
				Layouts.pressToContinue();
				break;
		}
		return retorno;
	}
}
