package domain.model;

import java.util.TreeSet;

import domain.database.Database;

public class ContactGroup implements Comparable<Object>{

	protected String name;
	private ContactGroup father;
	private TreeSet<Contact> contacts = new TreeSet<Contact>();
	private TreeSet<ContactGroup> groups = new TreeSet<ContactGroup>();
	
	public ContactGroup(String name) {
		super();
		this.name = name;
	}
	
	public ContactGroup getFather() {
		return father;
	}

	public void setFather(ContactGroup father) {
		this.father = father;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public TreeSet<Contact> getContacts() {
		return contacts;
	}


	public void setContacts(TreeSet<Contact> contacts) {
		this.contacts = contacts;
	}


	public TreeSet<ContactGroup> getGroups() {
		return groups;
	}


	public void setGroups(TreeSet<ContactGroup> groups) {
		this.groups = groups;
	}


	public void addContact(Contact contact) {
		this.contacts.add(contact);
	}
	
	public void addContactGroup(ContactGroup contactGroup) {
		this.groups.add(contactGroup);
		contactGroup.father = this;
	}
	
	public int compareTo(Object obj){
        ContactGroup proximo = (ContactGroup)obj;
        return this.name.compareTo(proximo.getName());
    }
	
	public void save(Database myData) {
		myData.groups.add(this);
	}
}
