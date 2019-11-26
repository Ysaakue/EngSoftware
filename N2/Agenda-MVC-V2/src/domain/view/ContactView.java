package domain.view;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

import domain.model.Contact;
import domain.model.ContactGroup;

public class ContactView {
	static Scanner sc = new Scanner(System.in);
	
	// Index
	public static void indexContact(TreeSet<Contact> contacts, TreeSet<ContactGroup> groups) {
		System.out.println("   --- INDEX CONTACT ---");
		for(Contact contact: contacts) {
			showContact(contact,0);
		}
		for(ContactGroup group: groups) {
			showGroup(group, 0);
		}
	}
	
	// Show Group
	public static void showGroup(ContactGroup group, int spaces) {
		if(group.getContacts().size()>0 || group.getGroups().size()>0){
			int realSpaces = spaces;
			if(spaces>0) {
				realSpaces= spaces * 3;
			}
			String tab = "";
			for(int x=0;x<realSpaces;x++) {
				tab+=" ";
			}
			System.out.println(tab+"*In "+group.getName()+":");
		}
		if(group.getContacts().size()>0) {
			for(Contact contact: group.getContacts()) {
				showContact(contact,spaces+1);
			}
		}
		if(group.getGroups().size()>0){
			for(ContactGroup groupC: group.getGroups()) {
				showGroup(groupC,spaces+1);
			}
		}
	}
	
	// Show Contact
	public static void showContact(Contact contact, int spaces) {
		int realSpaces = spaces;
		if(spaces>0) {
			realSpaces= spaces * 3;
		}
		String tab = "";
		for(int x=0;x<realSpaces;x++) {
			tab+=" ";
		}
		System.out.println(tab+"-Name: "+contact.getName());
		System.out.println(tab+" Email Adress: "+contact.getEmailAddress());
		System.out.println(tab+" Fax Number: "+contact.getFaxNumber());
		System.out.println(tab+" Primary Contact Method: "+contact.getPrimaryContactMethod()+"\n");
		
	}
	
	// Form
	public static HashMap<String, String> formContact() {
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