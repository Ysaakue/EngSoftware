package domain.controller;

import java.util.HashMap;

import domain.model.ContactGroup;
import domain.view.ContactGroupView;

public class ContactGroupController{
	ContactGroupView view;
	
	public ContactGroupController () {
		this.view = new ContactGroupView();
	}
	// Index ContactGroup
	public void index() {
		view.index(ContactGroup.all());
	}
	
	// New ContactGroup
	public String create() {
		try{
			HashMap<String, String> mapaGroup = view.form();
			ContactGroup newGroup = new ContactGroup((String)mapaGroup.get("nome"));
			newGroup.save();
			return " -- Successfully Created Contact Group -- ";
		} catch (SaveException e) {
			new SaveException();
			return " -- Error Trying to Save Contact Group -- ";
		}
	}
}
