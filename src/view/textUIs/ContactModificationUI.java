package view.textUIs;

import util.FormatChecker;

public class ContactModificationUI extends TextUI{
    ContactModificationUI() {
        super();
    }

    @Override
    public void start() {

    }

    public void rename() {
        System.out.println("New name: ");
        String newName = scanner.nextLine();
        selectedContact.setName(newName);
    }

    public void addPhoneNumber() {
        System.out.println("New Phone number: ");
        String newPhoneNumber = getWellFormattedPhoneNumber();
        selectedContact.addPhoneNumber(newPhoneNumber);
    }

    private String getWellFormattedPhoneNumber() {
        String phoneNumber;
        while (true) {
            phoneNumber = scanner.nextLine();
            if (FormatChecker.checkPhoneNumber(phoneNumber))
                break;
        }
        return phoneNumber;
    }

    public void removePhoneNumber() {
        if (selectedContact.getPhoneNumbers().isEmpty())
            System.out.println("No phone number to remove");
        else {
            String phoneNumber = selectValidPhoneNumber();
            selectedContact.removePhoneNumber(phoneNumber);
        }
    }


    private void showPhoneNumbers() {
        System.out.println("Select a phone number from these");
        System.out.println(selectedContact.getPhoneNumbers());
    }

    private String selectValidPhoneNumber() {
        showPhoneNumbers();
        String selectedPhoneNumber;
        while (true) {
            selectedPhoneNumber = scanner.nextLine();
            if (selectedContact.getPhoneNumbers().contains(selectedPhoneNumber))
                break;
        }
        return selectedPhoneNumber;
    }

    public void deleteContact() {
        System.out.println("Do you really want to delete this contact? y/n");
        String response = scanner.nextLine().trim().toLowerCase();
        if (response.equals("y")) {
            contactBook.deleteContact(selectedContact.getId());
            selectedContact = null;
        }
    }


}
