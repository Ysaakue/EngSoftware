package domain;

import java.util.Scanner;

import domain.controllers.AddressBookController;
import domain.controllers.ContactController;
import domain.models.Account;
import domain.views.Layouts;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcao = 0;
		Account session = new Account();
		do{
			Layouts.clear();
			Layouts.menu();
			opcao = sc.nextInt();
			sc.nextLine();
			System.out.println("");
			App.processa(opcao,session);
		}while(opcao!=0);
		sc.close();
		System.out.println("\n\n -- SISTEMA ENCERRADO --\n");
	}
	
	public static void processa(int opcao, Account session) {
		switch(opcao) {
			case 1:
				ContactController.newContact(session);
				break;
			case 2:
				AddressBookController.newAddressBook(session);
				break;
			case 4:
				AddressBookController.indexAddressBook(session);
				Layouts.pressToContinue();
				break;
			case 5:
				ContactController.indexContact(session);
				Layouts.pressToContinue();
			default:
				System.out.println("Invalid option");
				Layouts.pressToContinue();
				break;
		}
	}

}
