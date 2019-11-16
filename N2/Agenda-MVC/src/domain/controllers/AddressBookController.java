package domain.controllers;

import domain.models.Account;
import domain.models.AddressBook;
import domain.views.AddressBookView;

public class AddressBookController {
	// --INDEX--
	public static void indexAddressBook(Account account) {
		AddressBookView.indexAddressBook(account.getAddressBooks());
	}
	// --NEW--
	public static void newAddressBook(Account account) {
		AddressBook ab = AddressBookView.form();
		createAdressBook(account, ab.getName());
	}
	
	// --CREATE--
	public static AddressBook createAdressBook(Account session, String name) {
		AddressBook newBook = new AddressBook(session,name);
		session.addAddressBook(newBook);
		
		return newBook;
	}
}
