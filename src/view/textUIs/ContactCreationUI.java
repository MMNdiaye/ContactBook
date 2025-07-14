package view.textUIs;

import model.Contact;
import util.NonUniquePhoneNumberException;


class ContactCreationUI extends TextUI{
    private Contact createdContact;

    ContactCreationUI() {
        super();
    }

    @Override
    public void start() {
        askName();
        askPhoneNumbers();
        addCreatedContact();
    }

    private void askName() {
        System.out.println("Name: ");
        String name = scanner.nextLine();
        createdContact = new Contact(name);
    }

    private void askPhoneNumbers() {
        while (isAddingPhoneNumber())
            createdContact.addPhoneNumber(askPhoneNumber());
    }

    private String askPhoneNumber() {
        String phoneNumber;
        do {
            System.out.println("Phone number:");
            phoneNumber = scanner.nextLine();
        } while (!isPhoneNumberWellFormatted(phoneNumber));
        return phoneNumber;
    }

    private boolean isPhoneNumberWellFormatted(String phoneNumber) {
        String pattern = "(\\(\\+\\d{3}\\) )?\\d{7,9}";
        boolean isWellFormatted = phoneNumber.matches(pattern);
        if (!isWellFormatted)
            System.out.println("Not well formatted");
        return isWellFormatted;
    }

    private boolean isAddingPhoneNumber() {
        System.out.println("Do you want to add a phone number? y/n");
        String response = scanner.nextLine().toLowerCase().trim();
        return response.equals("y");
    }

    private void addCreatedContact() {
        try {
            contactBook.addContact(createdContact);
        } catch (NonUniquePhoneNumberException e) {
            System.out.println(e.getMessage());
            System.out.println("Couldn't create contact");
        }
        createdContact = null;
    }
}
