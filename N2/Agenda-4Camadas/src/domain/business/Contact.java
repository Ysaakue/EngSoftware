package domain.business;

public class Contact implements Comparable<Object>{
	protected int id;
	protected String name;
	protected String emailAddress;
	protected String faxNumber;
	protected String primaryContactMethod;
	
	public Contact(int id, String name, String emailAddress, String faxNumber, String primaryContactMethod) {
		super();
		this.id = id;
		this.name = name;
		this.emailAddress = emailAddress;
		this.faxNumber = faxNumber;
		this.primaryContactMethod = primaryContactMethod;
	}
	
	public Contact(String name, String emailAddress, String faxNumber, String primaryContactMethod) {
		super();
		this.name = name;
		this.emailAddress = emailAddress;
		this.faxNumber = faxNumber;
		this.primaryContactMethod = primaryContactMethod;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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

	public int compareTo(Object obj){
        Contact proximo = (Contact)obj;
        return this.name.compareTo(proximo.getName());
    }
}
