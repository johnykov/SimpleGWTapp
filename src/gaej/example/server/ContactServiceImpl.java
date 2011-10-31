package gaej.example.server;

import java.util.ArrayList;
import java.util.List;

import gaej.example.client.ContactService;
import gaej.example.shared.Contact;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ContactServiceImpl extends RemoteServiceServlet implements
		ContactService {
	private static final long serialVersionUID = 1L;
	//private ContactDAO contactDAO = new ContactDAOMock();
	private ContactDAO contactDAO = new ContactJdoDAO();

	@Override
	public List<Contact> listContacts() {
		List<Contact> listContacts = contactDAO.listContacts();
		return new ArrayList<Contact>(listContacts);
	}

	@Override
	public void addContact(Contact contact) {
		contactDAO.addContact(contact);
	}

	@Override
	public void removeContact(Contact contact) {
		contactDAO.removeContact(contact);
	}

	@Override
	public void updateContact(Contact contact) {
		contactDAO.updateContact(contact);
	}
}
