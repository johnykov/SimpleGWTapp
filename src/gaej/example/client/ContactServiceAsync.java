package gaej.example.client;

import java.util.List;

import gaej.example.shared.Contact;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ContactServiceAsync {

	void addContact(Contact contact, AsyncCallback<Void> callback);

	void listContacts(AsyncCallback<List<Contact>> callback);

	void removeContact(Contact contact, AsyncCallback<Void> callback);

	void updateContact(Contact contact, AsyncCallback<Void> callback);

}
