package domain.models;

import java.util.TreeSet;

public class Contact implements Comparable{
	protected String name;
	protected String emailAdress;
	protected String faxNumber;
	protected String primaryContactMethod;
	private TreeSet<ContactGroup> contactGroups;
	public TreeSet<AddressBook> isContainedIn;
	
	public Contact() {
		this.isContainedIn = new TreeSet<AddressBook>();
		this.contactGroups = new TreeSet<ContactGroup>();
	}
	
	public Contact(String name, String emailAdress, String faxNumber, String primaryContactMethod, AddressBook addressBook) {
		super();
		this.name = name;
		this.emailAdress = emailAdress;
		this.faxNumber = faxNumber;
		this.primaryContactMethod = primaryContactMethod;
		this.isContainedIn = new TreeSet<AddressBook>();
		this.isContainedIn.add(addressBook);
		this.contactGroups = new TreeSet<ContactGroup>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAdress() {
		return emailAdress;
	}

	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getPrimaryContactMethod() {
		return primaryContactMethod;
	}

	public void setPrimaryContactMethod(String primaryContactMethod) {
		this.primaryContactMethod = primaryContactMethod;
	}

	public TreeSet<ContactGroup> getContactGroups() {
		return contactGroups;
	}

	public void setContactGroups(TreeSet<ContactGroup> contactGroups) {
		this.contactGroups = contactGroups;
	}

	public TreeSet<AddressBook> getIsContainedIn() {
		return isContainedIn;
	}

	public void setIsContainedIn(TreeSet<AddressBook> isContainedIn) {
		this.isContainedIn = isContainedIn;
	}
	
	public void addInAdressBook(AddressBook book) {
		this.isContainedIn.add(book);
	}
	
	public int compareTo(Object obj){
        Contact proximo = (Contact)obj;
        return this.name.compareTo(proximo.getName());
    }
}
