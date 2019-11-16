package domain.models;

import java.util.TreeSet;

public class Account {
	protected TreeSet<AddressBook> addressBooks;
	
	public Account() {
		this.addressBooks = new TreeSet<AddressBook>();
		this.addressBooks.add(new AddressBook(this,"MyAddressBook"));
	}
	
	public TreeSet<AddressBook> getAddressBooks() {
		return addressBooks;
	}

	public void setAddressBooks(TreeSet<AddressBook> addressBooks) {
		this.addressBooks = addressBooks;
	}

	public void addAddressBook(AddressBook newAddressBook) {
		this.addressBooks.add(newAddressBook);
	}
}
