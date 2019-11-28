package domain.view;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

import domain.model.Contact;

public class ContactView {
	static Scanner sc = new Scanner(System.in);
	
	// Index
	public void index(TreeSet<Contact> contacts) {
		System.out.println("   --- INDEX CONTACT ---"+ contacts.size());
		for(Contact contact: contacts) {
			showContact(contact);
		}
	}
	
	// Show Contact
	public void showContact(Contact contact) {
		System.out.println("-Name: "+contact.getName());
		System.out.println(" Email Adress: "+contact.getEmailAddress());
		System.out.println(" Fax Number: "+contact.getFaxNumber());
		System.out.println(" Primary Contact Method: "+contact.getPrimaryContactMethod()+"\n");
		
	}
	
	// Form
	public HashMap<String, String> form() {
		HashMap<String, String> mapContact = new HashMap<String, String>();
		System.out.println("   --- FORM FOR CONTACT ---");
		System.out.print("Name:");
		mapContact.put("nome", sc.next());
		System.out.print("Email Address:");
		mapContact.put("emailAddress", sc.next());
		System.out.print("Fax Number:");
		mapContact.put("faxNumber", sc.next());
		System.out.print("Primary Contact Method:");
		mapContact.put("primaryContactMethod", sc.next());
		return mapContact;
	}
	
	public static int menu() {
		System.out.println("   --- CHOOSE WHERE ADD CONTACT ---");
		System.out.println("1) Add to AddressBook");
		System.out.println("2) Add to a Contact Group");
		System.out.println("0) Cancel");
		int option = 0;
		do {
			System.out.print(  "  Type the option:");

			option = sc.nextInt();
			sc.nextLine();
			if(option>2 || option<0) {				
				System.out.println("\nInvalid option");
			}
			System.out.println("");
		}while(option>2 || option<0);
		return option;
	}
}