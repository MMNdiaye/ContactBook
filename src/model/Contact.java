package model;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    private long id;
    private String name;
    private List<String> phoneNumbers;

    Contact(String name) {
        this.id = generateId();
        this.name = name;
        this.phoneNumbers = new ArrayList<>();
    }

    private long generateId() {
        return 1;
    }

    public void addPhoneNumber(String phoneNumber) {
        phoneNumbers.add(phoneNumber);
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

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

}
