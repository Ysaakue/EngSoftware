package domain.model;

import domain.database.Database;

public class Contact  implements Comparable<Object>{
	protected String name;
	protected String emailAddress;
	protected String faxNumber;
	protected String primaryContactMethod;
	
	public Contact(String name, String emailAddress, String faxNumber, String primaryContactMethod) {
		super();
		this.name = name;
		this.emailAddress = emailAddress;
		this.faxNumber = faxNumber;
		this.primaryContactMethod = primaryContactMethod;
	}
	
	public String getName() {
		return name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public String getPrimaryContactMethod() {
		return primaryContactMethod;
	}

	public int compareTo(Object obj){
        Contact proximo = (Contact)obj;
        return this.name.compareTo(proximo.getName());
    }

	public void save(Database myData) {
		myData.contacts.add(this);
	}

}
