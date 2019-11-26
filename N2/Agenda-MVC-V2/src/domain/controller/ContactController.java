package domain.controller;

import java.util.HashMap;

import domain.database.Database;
import domain.model.Contact;
import domain.model.ContactGroup;
import domain.view.ContactGroupView;
import domain.view.ContactView;
import domain.view.Layouts;

public class ContactController {
	
	// Index ContactGroup
	public static void indexContact(Database myData) {
		ContactView.indexContact(myData.getContacts(), myData.getGroups());
	}
	
	// NEW
	public static String newContact(Database myData) {
		HashMap<String, String> mapaContact = ContactView.formContact();
		Contact newContact = new Contact((String)mapaContact.get("nome"),(String)mapaContact.get("emailAddress"),(String)mapaContact.get("faxNumber"),(String)mapaContact.get("primaryContactMethod"));
		if(myData.getGroups().size()>0) {
			int option = ContactView.menu();
			if (option==0) {
				return " -- Canceled --";
			} else if(option == 2) {
				Layouts.clear();
				ContactGroup groupF = ContactGroupView.chooseGroup(myData.getGroups());
				groupF.addContact(newContact);
				return " -- Successfully Created Contact on "+groupF.getName()+" -- ";
			} else {
				newContact.save(myData);
				return " -- Successfully Created Contact -- ";
			}
		} else {
			newContact.save(myData);;
			return " -- Successfully Created Contact -- ";
		}
	}
}