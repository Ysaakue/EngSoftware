package domain.controller;

import java.util.HashMap;

import domain.model.Contact;
import domain.view.ContactView;

public class ContactController {
	ContactView view;
	
	public ContactController() {
		this.view = new ContactView();
	}
	
	// Index ContactGroup
	public void index() {
		view.index(Contact.all());
	}
	
	// NEW
	public String create() {
		try{
			HashMap<String, String> mapaContact = view.form();
			Contact newContact = new Contact((String)mapaContact.get("nome"),(String)mapaContact.get("emailAddress"),(String)mapaContact.get("faxNumber"),(String)mapaContact.get("primaryContactMethod"));
			newContact.save();;
			return " -- Successfully Created Contact -- ";
		} catch (SaveException e) {
			new SaveException();
			return " -- Error Trying to Save Contact -- ";
		}
	}
}