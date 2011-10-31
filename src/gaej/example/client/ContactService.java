package gaej.example.client;

import gaej.example.shared.Contact;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("ContactService") //contacts
public interface ContactService extends RemoteService {
	   List<Contact> listContacts();
	    void addContact(Contact contact);
	    void removeContact(Contact contact);
	    void updateContact(Contact contact);
}
