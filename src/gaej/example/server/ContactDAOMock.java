package gaej.example.server;

import gaej.example.shared.Contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ContactDAOMock implements ContactDAO {
	Map<String, Contact> map = new LinkedHashMap<String, Contact>();

	{
		map.put("rhightower@mammatus.com", new Contact("Rick Hightower",
				"rhightower@mammatus.com", "520-555-1212"));
		map.put("scott@mammatus.com", new Contact("Scott Fauerbach",
				"scott@mammatus.com", "520-555-1213"));
		map.put("bob@mammatus.com", new Contact("Bob Dean", "bob@mammatus.com",
				"520-555-1214"));

	}

	public void addContact(Contact contact) {
		String email = contact.getEmail();
		map.put(email, contact);
	}

	public List<Contact> listContacts() {
		return Collections
				.unmodifiableList(new ArrayList<Contact>(map.values()));
	}

	public void removeContact(Contact contact) {
		map.remove(contact.getEmail());
	}

	public void updateContact(Contact contact) {
		map.put(contact.getEmail(), contact);
	}
}
