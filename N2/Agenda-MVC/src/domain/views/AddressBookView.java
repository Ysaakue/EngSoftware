package domain.views;

import java.util.Scanner;
import java.util.TreeSet;

import domain.models.AddressBook;

public class AddressBookView {
	// --INDEX--
	public static void indexAddressBook(TreeSet<AddressBook> lista) {
		System.out.println("   --- INDEX ADDRESS BOOK ---");
		for(AddressBook livro: lista) {
			showOneAddressBook(livro);
			System.out.println();
		}
	}
	// --FORM--
	public static AddressBook form() {
		Scanner sc = new Scanner(System.in);
		System.out.println("   --- FORM FOR ADDRESS BOOK ---");
		System.out.println("Name");
		String nome = sc.nextLine();
		AddressBook ab = new AddressBook();
		ab.setName(nome);
		return ab;
	}
	// --SHOW--
	public static void showAddressBook(AddressBook addressBook) {
		System.out.println("   --- SHOW ADDRESS BOOK ---");
		showOneAddressBook(addressBook);
	}
	public static void showOneAddressBook(AddressBook addressBook) {
		System.out.println("Name: " + addressBook.getName());
		System.out.println("Contacts(amount): " + addressBook.getContacts().size());
		System.out.println("Contacts Groups(amount): " + addressBook.getContactGroups().size());
	}
}
