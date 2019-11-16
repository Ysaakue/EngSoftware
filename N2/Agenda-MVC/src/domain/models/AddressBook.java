package domain.models;

import java.util.TreeSet;

public class AddressBook implements Comparable{
	private TreeSet<Contact> contacts;
	private TreeSet<ContactGroup> contactGroups;
	public Account account;
	protected String name;
	
	
	public AddressBook () {}
	
	public AddressBook(Account account, String name) {
		super();
		this.account = account;
		this.name = name;
		this.contacts = new TreeSet<Contact>();
		this.contactGroups = new TreeSet<ContactGroup>();
	}

	public TreeSet<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(TreeSet<Contact> contacts) {
		this.contacts = contacts;
	}

	public TreeSet<ContactGroup> getContactGroups() {
		return contactGroups;
	}

	public void setContactGroups(TreeSet<ContactGroup> contactGroups) {
		this.contactGroups = contactGroups;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addContact(Contact contato) {
		this.contacts.add(contato);
	}
	
	public int compareTo(Object obj){
        AddressBook proximo = (AddressBook)obj;
        return this.name.compareTo(proximo.getName());
    }
}
