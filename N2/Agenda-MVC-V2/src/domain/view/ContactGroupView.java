package domain.view;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

import domain.model.ContactGroup;

public class ContactGroupView {
	static Scanner sc = new Scanner(System.in);
	
	// Index
	public static void indexGroup(TreeSet<ContactGroup> groups) {
		System.out.println("   --- INDEX CONTACT GROUP ---");
		for(ContactGroup group: groups) {
			showGroup(group, 0);
		}
	}
	
	// Show
	public static void showGroup(ContactGroup group, int spaces) {
		int realSpaces = spaces;
		if(spaces>0) {
			realSpaces= spaces * 6;
		}
		for(int x=0;x<realSpaces;x++) {
			System.out.print(" ");
		}
		System.out.println("Name: "+group.getName());
		if(group.getGroups().size()>0) {
			for(int x=0;x<realSpaces;x++) {
				System.out.print(" ");
			}
			System.out.println("Groups:");
			for(ContactGroup groupC: group.getGroups()) {
				showGroup(groupC, spaces+1);
			}
		}
	}
	
	// Form
	public static HashMap<String, String> formGroup() {
		HashMap<String, String> mapaGroup = new HashMap<String, String>();
		System.out.println("   --- FORM FOR CONTACT GROUP ---");
		System.out.print("Name:");
		mapaGroup.put("nome", sc.next());
		return mapaGroup;
	}
	
	public static int menu() {
		System.out.println("   --- CHOOSE WHERE ADD GROUP ---");
		System.out.println("1) Add to AddressBook");
		System.out.println("2) Add to another Contact Group");
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
	
	public static ContactGroup chooseGroup(TreeSet<ContactGroup> groups) {
		System.out.println("   --- CHOOSE WHICH GROUP TO ADD ---");
		LinkedList<ContactGroup> local = listGroups(groups, new LinkedList<ContactGroup>());
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
	
	private static LinkedList<ContactGroup> listGroups(TreeSet<ContactGroup> groups,LinkedList<ContactGroup> retorno ){
		for(ContactGroup group: groups){
			retorno.add(group);
			System.out.println(retorno.size()+") "+group.getName());
			if(group.getGroups().size()>0) {
				retorno = listGroups(group.getGroups(), retorno);
			}
		}
		return retorno;
	}
}
