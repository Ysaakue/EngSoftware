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
			if(ContactGroup.all().size()>0) {
				int opcao = view.menu();
				if(opcao == 0) {
					return " -- Canceled -- ";
				} else if(opcao == 1) {
					newGroup.save();
					return " -- Successfully Created Contact Group -- ";
				} else {
					ContactGroup gF = view.chooseGroup(ContactGroup.all());
					newGroup.setFather(gF.getId());
					int id = newGroup.save();
					newGroup.setId(id);
					newGroup.addFather();
					return " -- Successfully Created Contact Group on "+gF.getName()+" -- ";
				}
			} else {				
				newGroup.save();
				return " -- Successfully Created Contact Group -- ";
			}
		} catch (SaveException e) {
			new SaveException();
			return " -- Error Trying to Save Contact Group -- ";
		}
	}
}
