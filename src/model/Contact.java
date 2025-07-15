package model;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class Contact {
    private static long lastId = 0;
    private long id;
    private String name;
    private Set<String> phoneNumbers;

    public Contact(String name) {
        this.id = generateId();
        this.name = name;
        this.phoneNumbers = new HashSet<>();
    }

    private long generateId() {
        lastId++;
        return lastId;
    }

    public void addPhoneNumber(String phoneNumber) {
        phoneNumbers.add(phoneNumber);
    }

    public void removePhoneNumber(String phoneNumber) {
        phoneNumbers.remove(phoneNumber);
    }

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    @Override
    public String toString() {
        return "{name: " + name
                + ", phone numbers: " + phoneNumbers +"}";
    }
}
