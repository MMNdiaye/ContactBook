package storage;

import model.Contact;
import util.NonUniquePhoneNumberException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactBook {
    private Map<Long, Contact> contactMap;

    public ContactBook() {
        contactMap = new HashMap<>();
    }

    public void addContact(Contact contact) {
        contactMap.put(contact.getId(), contact);
    }

    public List<Contact> contactsByName(String name) {
        List<Contact> contacts = contactMap.values().stream()
                .filter(contact -> contact.getName().equals(name))
                .toList();
        return contacts;
    }

    public Contact contactByPhoneNumber(String phoneNumber)
            throws NonUniquePhoneNumberException{
        List<Contact> contacts = contactMap.values().stream()
                .filter(cont -> cont.getPhoneNumbers().contains(phoneNumber))
                .toList();
       if (contacts.size() > 1)
           throw new NonUniquePhoneNumberException();
        return contacts.get(0);
    }

    public void deleteContact(long contactId) {
        contactMap.remove(contactId);
    }

}
