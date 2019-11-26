package domain.database;

import java.util.TreeSet;

import domain.model.Contact;
import domain.model.ContactGroup;

public class Database {
	public TreeSet<ContactGroup> groups = new TreeSet<ContactGroup>();
	public TreeSet<Contact> contacts = new TreeSet<Contact>();
	
	public Database() {}

	public TreeSet<ContactGroup> getGroups() {
		return groups;
	}

	public TreeSet<Contact> getContacts() {
		return contacts;
	}
}
