package domain.controller;

import java.util.HashMap;

import domain.database.Database;
import domain.model.ContactGroup;
import domain.view.ContactGroupView;
import domain.view.Layouts;

public class ContactGroupController {
	// Index ContactGroup
	public static void indexGroup(Database myData) {
		ContactGroupView.indexGroup(myData.getGroups());
	}
	
	// New ContactGroup
	public static String newGroup(Database myData) {
		HashMap<String, String> mapaGroup = ContactGroupView.formGroup();
		ContactGroup newGroup = new ContactGroup((String)mapaGroup.get("nome"));
		if(myData.getGroups().size()>0) {
			int option = ContactGroupView.menu();
			if (option==0) {
				return " -- Canceled --";
			} else if(option == 2) {
				Layouts.clear();
				ContactGroup groupF = ContactGroupView.chooseGroup(myData.getGroups());
				groupF.addContactGroup(newGroup);
				return " -- Successfully Created Contact Group on "+groupF.getName()+" -- ";
			} else {
				newGroup.save(myData);
				return " -- Successfully Created Contact Group -- ";
			}
		} else {
			newGroup.save(myData);
			return " -- Successfully Created Contact Group -- ";
		}
	}
}
