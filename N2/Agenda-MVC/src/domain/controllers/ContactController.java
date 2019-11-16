package domain.controllers;

import java.util.Scanner;
import java.util.TreeSet;

import domain.models.Account;
import domain.models.AddressBook;
import domain.models.Contact;
import domain.views.ContactView;

public class ContactController {
	// --INDEX--
		public static void indexContact(Account account) {
			ContactView.indexContact(account.getAddressBooks());
		}
		// --NEW--
		public static void newContact(Account account) {
			Contact c = ContactView.form();
			if(account.getAddressBooks().size()>1) {
				int x = ContactView.listBooks(account);
				for(AddressBook livro: account.getAddressBooks()) {
					if(account.getAddressBooks().headSet(livro).size() == x) {
						createContact(livro, c);
					}
				}
			} else {
				createContact(account.getAddressBooks().first(), c);
			}
		}
		
		// --CREATE--
		public static Contact createContact(AddressBook book, Contact contact) {
			book.addContact(contact);
			contact.addInAdressBook(book);
			
			return contact;
		}
}
