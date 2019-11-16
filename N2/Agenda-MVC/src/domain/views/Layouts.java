package domain.views;

import java.util.Scanner;

public class Layouts {
	public static void menu() {
		System.out.println("\n_____________MENU INICIAL_____________");
		System.out.println(  "|                                    |");
		System.out.println(  "| 1) Add Contact                     |");
		System.out.println(  "| 2) Add Address Book                |");
		System.out.println(  "| 3) Add Contact to Address Group    |");
		System.out.println(  "| 4) Index Address Book              |");
		System.out.println(  "| 5) Index Contacts                  |");
		System.out.println(  "|                                    |");
		System.out.println(  "| 0) Sair                            |");
		System.out.println(  "|____________________________________|");
		System.out.print(  "\nEntre com a opção:");
	}
	
	public static void clear() {
		for (int i = 0; i < 100; ++i)  
		       System.out.println();  
	}
	
	public static void pressToContinue() {
		Scanner s = new Scanner(System.in);
		System.out.println("\nPress enter to continue.");
		String st = s.nextLine();
		//s.close();
	}
}
