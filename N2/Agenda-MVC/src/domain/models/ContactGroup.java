package domain.models;

import java.util.TreeSet;

public class ContactGroup {
	protected String name;
	protected ContactGroup parent;
	private AddressBook addressBook;
	public TreeSet<ContactGroup> child;
	protected TreeSet<Contact> contacts;
	
	public ContactGroup(String name, ContactGroup parent, AddressBook addressBook) {
		super();
		this.name = name;
		this.parent = parent;
		this.addressBook = addressBook;
		this.child = new TreeSet<ContactGroup>();
		this.contacts = new TreeSet<Contact>();
	}

	public TreeSet<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(TreeSet<Contact> contacts) {
		this.contacts = contacts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addContact(Contact contact) {
		this.contacts.add(contact);
	}

	public ContactGroup getParent() {
		return parent;
	}

	public void setParent1(ContactGroup parent) {
		this.parent = parent;
	}

	public TreeSet<ContactGroup> getChild() {
		return child;
	}

	public void setChild(TreeSet<ContactGroup> child) {
		this.child = child;
	}

	public void setParent(ContactGroup parent) {
		this.parent = parent;
	}

	public AddressBook getAddressBook() {
		return addressBook;
	}

	public void setAddressBook(AddressBook addressBook) {
		this.addressBook = addressBook;
	}
	
}
