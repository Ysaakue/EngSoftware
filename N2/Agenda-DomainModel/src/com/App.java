package com;

import java.util.Scanner;

import com.IU.ContactView;
import com.IU.GroupView;
import com.IU.Layouts;

public class App {
	GroupView grupoView;
	ContactView contatoView;
	Layouts layout;
	
	private App() {
		this.contatoView = new ContactView();
		this.grupoView = new GroupView();
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
				contatoView.form();
				break;
			case 2:
				layout.clear();
				grupoView.form();
				break;
			case 3:
				layout.clear();
				contatoView.index();
				layout.pressToContinue();
				break;
			case 4:
				layout.clear();
				grupoView.index();
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
