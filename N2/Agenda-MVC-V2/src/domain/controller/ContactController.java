package domain.controller;

import java.util.HashMap;

import domain.model.Contact;
import domain.model.ContactGroup;
import domain.view.ContactGroupView;
import domain.view.ContactView;

public class ContactController {
	ContactView view;
	ContactGroupView gView;
	
	public ContactController() {
		this.view = new ContactView();
		this.gView = new ContactGroupView();
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
			if(ContactGroup.all().size()>0) {
				int opcao = gView.menu();
				if(opcao == 0) {
					return " -- Canceled -- ";
				} else if(opcao == 1) {
					newContact.save();
					return " -- Successfully Created Contact -- ";
				} else {
					ContactGroup gF = gView.chooseGroup(ContactGroup.all());
					int id = newContact.save();
					newContact.setId(id);
					newContact.addToGroup(gF.getId());
					return " -- Successfully Created Contact on "+gF.getName()+" -- ";
				}
			} else {
				newContact.save();
				return " -- Successfully Created Contact -- ";				
			}
		} catch (SaveException e) {
			new SaveException();
			return " -- Error Trying to Save Contact -- ";
		}
	}
}