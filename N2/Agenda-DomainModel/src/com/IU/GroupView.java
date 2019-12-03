package com.IU;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

import com.domain.Group;
import com.service.GroupController;

public class GroupView {
	private Scanner sc;
	private GroupController controller;
	
	public GroupView() {
		this.sc = new Scanner(System.in);
		this.controller = new GroupController();
	}
	
	// Index
	public void index() {
		TreeSet<Group> groups = controller.all();
		System.out.println("   --- INDEX CONTACT GROUP ---");
		for(Group group: groups) {
			showGroup(group, 0);
		}
	}
	
	// Show
	public void showGroup(Group group, int spaces) {
		System.out.println("Name: "+group.getName());
		System.out.println("Quant. Contatos: "+group.getQntd_contatos());
		if(group.getFather()!=0) {
			System.out.println("Inside: "+controller.getNameById(group.getFather()));			
		}
		System.out.println("");
	}
	
	// Form
	public void form() {
		HashMap<String, String> mapaGroup = new HashMap<String, String>();
		System.out.println("   --- FORM FOR CONTACT GROUP ---");
		System.out.print("Name:");
		mapaGroup.put("nome", sc.next());
		if(controller.all().size()>0) {
			int opcao = menu();
			if(opcao == 2) {
				Group gF = chooseGroup();
				controller.create(mapaGroup,opcao,gF);
			}
			controller.create(mapaGroup,opcao,new Group(""));
		} else {
			controller.create(mapaGroup);			
		}
	}
	
	public int menu() {
		System.out.println("   --- CHOOSE WHERE ADD GROUP ---");
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
		TreeSet<Group> groups = controller.all();
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
