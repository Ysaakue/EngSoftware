package domain;

import java.util.Scanner;

import domain.controller.ContactController;
import domain.controller.ContactGroupController;
import domain.view.Layouts;

public class App {
	ContactGroupController grupoController;
	ContactController contatoController;
	Layouts layout;
	
	private App() {
		this.contatoController = new ContactController();
		this.grupoController = new ContactGroupController();
		this.layout = new Layouts();
	}
	
	public static void main(String[] args) {
		App app = new App();
		Scanner sc = new Scanner(System.in);
		int opcao = 0;
		String notice = "";
		do{
			opcao = app.layout.menu(notice);
			notice = app.processa(opcao);
		}while(opcao!=0);
		sc.close();
		app.layout.exit();
	}
	
	public String processa(int opcao) {
		String retorno = "";
		switch(opcao) {
			case 0:
				layout.clear();
				break;
			case 1:
				layout.clear();
				retorno = contatoController.create();
				break;
			case 2:
				layout.clear();
				retorno = grupoController.create();
				break;
			case 3:
				layout.clear();
				contatoController.index();
				layout.pressToContinue();
				break;
			case 4:
				layout.clear();
				grupoController.index();
				layout.pressToContinue();
				break;
			default:
				System.out.println("Invalid option");
				layout.pressToContinue();
				break;
		}
		return retorno;
	}
}
