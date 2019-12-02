package domain.business;

import java.util.HashMap;
import java.util.TreeSet;

import domain.persistence.ContactDAO;

public class ContactController {
	private ContactDAO dao;
	
	public ContactController() {
		this.dao = new ContactDAO();
	}
	
	public TreeSet<Contact> all(){
		return dao.all();
	}
	
	public String create(HashMap<String, String> mapaContact ) {
		try{
			Contact newContact = new Contact((String)mapaContact.get("nome"),(String)mapaContact.get("emailAddress"),(String)mapaContact.get("faxNumber"),(String)mapaContact.get("primaryContactMethod"));
			dao.save(newContact);
			return " -- Successfully Created Contact -- ";				
		} catch (SaveException e) {
			new SaveException();
			return " -- Error Trying to Save Contact -- ";
		}
	}
	
	public String create(HashMap<String, String> mapaContact, int opcao, Group gF) {
		Contact newContact = new Contact((String)mapaContact.get("nome"),(String)mapaContact.get("emailAddress"),(String)mapaContact.get("faxNumber"),(String)mapaContact.get("primaryContactMethod"));
		
		if(opcao == 0) {
			return " -- Canceled -- ";
		} else if(opcao == 1) {
			dao.save(newContact);
			return " -- Successfully Created Contact -- ";
		} else {
			int id = dao.save(newContact);
			newContact.setId(id);
			dao.addToGroup(newContact, gF.getId());
			return " -- Successfully Created Contact on "+gF.getName()+" -- ";
		}
	}
	
	
	
	
	
}
