package domain.view;

import java.util.Scanner;

public class Layouts {
	static Scanner sc = new Scanner(System.in);

	public static int menu( String notice) {
		clear();
		if(!notice.equals("")) {
			System.out.println(notice + "\n");
		}
		System.out.println("\n_____________MENU INICIAL_____________");
		System.out.println(  "|                                    |");
		System.out.println(  "| 1) Add Contact                     |");
		System.out.println(  "| 2) Add Contact Group               |");
		System.out.println(  "| 3) Index Contacts                  |");
		System.out.println(  "| 4) Index Contacts Groups           |");
		System.out.println(  "|                                    |");
		System.out.println(  "| 0) Exit                            |");
		System.out.println(  "|____________________________________|");
		System.out.print(  "\nType the option:");

		int opcao = sc.nextInt();
		sc.nextLine();
		System.out.println("");
		return opcao;
	}
	
	public static void clear() {
		for (int i = 0; i < 100; ++i)  
		       System.out.println();  
	}
	
	public static void pressToContinue() {
		System.out.println("\nPress enter to continue.");
		sc.nextLine();
	}
}
