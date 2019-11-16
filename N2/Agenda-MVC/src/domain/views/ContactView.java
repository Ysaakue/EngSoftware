package domain.views;

import java.util.Scanner;
import java.util.TreeSet;

import domain.models.Account;
import domain.models.AddressBook;
import domain.models.Contact;
import domain.models.ContactGroup;

public class ContactView {
	// --INDEX--
	public static void indexContact(TreeSet<AddressBook> lista) {
		System.out.println("   --- INDEX CONTACT ---");
		for(AddressBook livro: lista) {
			for(Contact contato: livro.getContacts()) {
				showOneContact(contato);
			}
		}
	}
	// --FORM--
	public static Contact form() {
		Scanner sc = new Scanner(System.in);
		Contact c = new Contact();
		System.out.println("   --- FORM FOR ADDRESS BOOK ---");
		System.out.print("Name:");
		c.setName(sc.nextLine());
		System.out.print("Email Address:");
		c.setEmailAdress(sc.nextLine());
		System.out.print("Faz Number:");
		c.setFaxNumber(sc.nextLine());
		System.out.print("Primary Contact Method:");
		c.setPrimaryContactMethod(sc.nextLine());
		return c;
	}
	
	public static int listBooks(Account account) {
		System.out.println("Choose one Adress Book");
		int x = 0;
		for(AddressBook book: account.getAddressBooks()) {
			System.out.println(x + " - " + book.getName());
			x++;
		}
		x=0;
		do {

			Scanner sc = new Scanner(System.in);
			System.out.println("The number of the book:");
			x = sc.nextInt();
			if(x<0 || x>account.getAddressBooks().size()) {
				System.out.println("Invalid Option !!\n");
			}
		}while(x<0 || x>account.getAddressBooks().size());
		return x;
	}
	// --SHOW--
	public static void showContact(Contact contact) {
		System.out.println("   --- SHOW CONTACT ---");
		showOneContact(contact);
	}
	public static void showOneContact(Contact contact) {
		System.out.println("Name: " + contact.getName());
		System.out.println("Email Address: " + contact.getEmailAdress());
		System.out.println("Fax Number: " + contact.getFaxNumber());
		System.out.println("Primary Contact Method: " + contact.getPrimaryContactMethod());
		if(contact.getContactGroups().size() > 0) {
			System.out.println("Contacts Groups: ");
			for(ContactGroup grupo: contact.getContactGroups()) {
				System.out.println(" - " + grupo.getName());
			}
		}
	}
}
