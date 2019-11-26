package domain;

import java.util.Scanner;

import domain.controller.ContactController;
import domain.controller.ContactGroupController;
import domain.database.Database;
import domain.view.Layouts;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcao = 0;
		String notice = "";
		Database myData = new Database();
		do{
			opcao = Layouts.menu(notice);
			notice = App.processa(opcao, myData);
		}while(opcao!=0);
		sc.close();
		System.out.println("\n\n -- SISTEMA ENCERRADO --\n");
	}
	
	public static String processa(int opcao, Database myData) {
		String retorno = "";
		switch(opcao) {
			case 0:
				Layouts.clear();
				break;
			case 1:
				Layouts.clear();
				retorno = ContactController.newContact(myData);
				break;
			case 2:
				Layouts.clear();
				retorno = ContactGroupController.newGroup(myData);
				break;
			case 3:
				Layouts.clear();
				ContactController.indexContact(myData);
				Layouts.pressToContinue();
				break;
			case 4:
				Layouts.clear();
				ContactGroupController.indexGroup(myData);
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
