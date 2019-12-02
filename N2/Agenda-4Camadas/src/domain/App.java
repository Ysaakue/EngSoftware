package domain;


import domain.presentation.ContactView;
import domain.presentation.GroupView;
import domain.presentation.Layouts;


public class App {
	GroupView grupoView;
	ContactView contatoView;
	Layouts layout;
	String notice = "";
	
	private App() {
		this.contatoView = new ContactView();
		this.grupoView = new GroupView();
		this.layout = new Layouts();
	}
	
	public static void main(String[] args) {
		App app = new App();
		int opcao = 0;
		do{
			opcao = app.layout.menu(app.notice);
			app.processa(opcao);
		}while(opcao!=0);
		app.layout.exit();
	}
	
	public void processa(int opcao) {
		switch(opcao) {
			case 0:
				layout.clear();
				break;
			case 1:
				layout.clear();
				this.contatoView.form();
				break;
			case 2:
				layout.clear();
				this.grupoView.form();
				break;
			case 3:
				layout.clear();
				this.contatoView.index();
				layout.pressToContinue();
				break;
			case 4:
				layout.clear();
				this.grupoView.index();
				layout.pressToContinue();
				break;
			default:
				System.out.println("Invalid option");
				layout.pressToContinue();
				break;
		}
	}
}
