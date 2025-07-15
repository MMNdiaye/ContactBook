package storage;

import model.Contact;
import util.NonUniquePhoneNumberException;

import java.util.*;

public class ContactBook {
    private Map<Long, Contact> contactMap;

    public ContactBook() {
        contactMap = new HashMap<>();
    }

    public void addContact(Contact contact) throws NonUniquePhoneNumberException {
        checkPhoneNumbersValidity(contact.getPhoneNumbers());
        contactMap.put(contact.getId(), contact);
    }

    private void checkPhoneNumbersValidity(Set<String> phoneNumbers)
            throws NonUniquePhoneNumberException {
        Set<String> invalidPhoneNumbers = searchInvalidPhoneNumbers(phoneNumbers);
        if (!invalidPhoneNumbers.isEmpty())
            throw new NonUniquePhoneNumberException(invalidPhoneNumbers);
    }

    private Set<String> searchInvalidPhoneNumbers(Set<String> phoneNumbers) {
        Set<String> invalidPhoneNumbers = new HashSet<>();
        for (String phoneNumber : phoneNumbers)
            if (isPhoneNumberAssigned(phoneNumber))
                invalidPhoneNumbers.add(phoneNumber);
        return invalidPhoneNumbers;
    }

    private boolean isPhoneNumberAssigned(String phoneNumber) {
        for (Contact contact : contactMap.values()) {
            if (contact.getPhoneNumbers().contains(phoneNumber))
                return true;
        }
        return false;
    }

    public List<Contact> contactsByName(String name) {
        List<Contact> results = contactMap.values().stream()
                .filter(contact -> contact.getName().equals(name))
                .toList();
        return results;
    }


    public Contact contactByPhoneNumber(String phoneNumber)
            throws NoSuchElementException, NonUniquePhoneNumberException{
        List<Contact> results = contactMap.values().stream()
                .filter(cont -> cont.getPhoneNumbers().contains(phoneNumber))
                .toList();
        checkSearchByPhoneResults(results);
        return results.get(0);
    }

    private void checkSearchByPhoneResults(List<Contact> searchResults)
            throws NoSuchElementException, NonUniquePhoneNumberException {
        if (searchResults.size() == 0)
            throw new NoSuchElementException();
        if (searchResults.size() > 1)
            throw new NonUniquePhoneNumberException();
    }

    public Collection<Contact> getAllContacts() {
        return contactMap.values();
    }

    public void deleteContact(long contactId) {
        contactMap.remove(contactId);
    }

}
