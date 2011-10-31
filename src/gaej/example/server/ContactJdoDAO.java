package gaej.example.server;

import gaej.example.shared.Contact;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

public class ContactJdoDAO implements ContactDAO {
	private static final PersistenceManagerFactory pmfInstance = JDOHelper
			.getPersistenceManagerFactory("transactions-optional");

	public static PersistenceManagerFactory getPersistenceManagerFactory() {
		return pmfInstance;
	}

	public void addContact(Contact contact) {
		PersistenceManager pm = getPersistenceManagerFactory()
				.getPersistenceManager();
		try {
			pm.makePersistent(contact);
		} finally {
			pm.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Contact> listContacts() {
		PersistenceManager pm = getPersistenceManagerFactory()
				.getPersistenceManager();
		String query = "select from " + Contact.class.getName();
		return (List<Contact>) pm.newQuery(query).execute();
	}

	public void removeContact(Contact contact) {
		PersistenceManager pm = getPersistenceManagerFactory()
				.getPersistenceManager();
		try {
			pm.currentTransaction().begin();

			// We don't have a reference to the selected Product.
			// So we have to look it up first,
			contact = pm.getObjectById(Contact.class, contact.getId());
			pm.deletePersistent(contact);

			pm.currentTransaction().commit();
		} catch (Exception ex) {
			pm.currentTransaction().rollback();
			throw new RuntimeException(ex);
		} finally {
			pm.close();
		}
	}

	public void updateContact(Contact contact) {
		PersistenceManager pm = getPersistenceManagerFactory()
				.getPersistenceManager();
		String name = contact.getName();
		String phone = contact.getPhone();
		String email = contact.getEmail();

		try {
			pm.currentTransaction().begin();
			// We don't have a reference to the selected Product.
			// So we have to look it up first,
			contact = pm.getObjectById(Contact.class, contact.getId());
			contact.setName(name);
			contact.setPhone(phone);
			contact.setEmail(email);
			pm.makePersistent(contact);
			pm.currentTransaction().commit();
		} catch (Exception ex) {
			pm.currentTransaction().rollback();
			throw new RuntimeException(ex);
		} finally {
			pm.close();
		}
	}

}
