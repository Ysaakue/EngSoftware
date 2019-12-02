package domain.presentation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

import domain.business.Contact;
import domain.business.ContactController;
import domain.business.Group;
import domain.business.GroupController;

public class ContactView {
	private Scanner sc = new Scanner(System.in);
	private ContactController controller;
	private GroupController gcontroller;
	
	public ContactView() {
		this.controller = new ContactController();
		this.gcontroller = new GroupController();
	}
	
	// Index
	public void index() {
		TreeSet<Contact> contacts = controller.all();
		System.out.println("   --- INDEX CONTACT ---");
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
	public void form() {
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
		if(gcontroller.all().size()>0) {
			int opcao = menu();
			if(opcao == 2) {
				Group gF = chooseGroup();
				controller.create(mapContact,opcao,gF);
			}
			controller.create(mapContact,opcao,new Group(""));
		} else {
			controller.create(mapContact);			
		}
	}
	
	public int menu() {
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
	
	public Group chooseGroup() {
		TreeSet<Group> groups = gcontroller.all();
		System.out.println("   --- CHOOSE WHICH GROUP TO ADD ---");
		LinkedList<Group> local = listGroups(groups, new LinkedList<Group>());
		int option = 0;
		do {
			System.out.print("Type the option:");
			option = sc.nextInt();
			if(option>local.size() || option<0) {				
				System.out.println("\nInvalid option");
			}
		}while(option>local.size() || option<0);
		return local.get(option-1);
	}
	
	private LinkedList<Group> listGroups(TreeSet<Group> groups,LinkedList<Group> retorno ){
		for(Group group: groups){
			retorno.add(group);
			System.out.println(retorno.size()+") "+group.getName());
		}
		return retorno;
	}
}