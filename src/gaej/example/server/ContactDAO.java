package gaej.example.server;

import gaej.example.shared.Contact;

import java.util.List;

public interface ContactDAO {
	void addContact(Contact contact);

	void removeContact(Contact contact);

	void updateContact(Contact contact);

	List<Contact> listContacts();
}
