package view.textUIs;

import model.Contact;

import java.util.List;
import java.util.NoSuchElementException;

public class ContactSelectionUI extends TextUI{
    private boolean isSelectedByName;
    private boolean isSelectedByPhoneNumber;
    private List<Contact> searchResults;

    ContactSelectionUI() {
        super();
    }

    @Override
    public void start() {
        askCriteria();
        selectContact();
        System.out.println(selectedContact);
    }

    public void askCriteria() {
        System.out.println("Select by name? y/n");
        readCriteria();
    }

    private void readCriteria() {
        String response = scanner.nextLine().trim().toLowerCase();
        if (response.equals("y")) {
            isSelectedByName = true;
            return;
        }
        isSelectedByPhoneNumber = true;
    }

    private void selectContact() {
        if (isSelectedByName)
            selectByName();
        if (isSelectedByPhoneNumber)
            selectByPhoneNumber();
    }

    private void selectByName() {
        searchContactsByName();
        selectContactFromResults();
    }

    private void searchContactsByName() {
        System.out.println("Name: ");
        String name = scanner.nextLine();
        searchResults = contactBook.contactsByName(name);
    }

    private void selectContactFromResults() {
        if (searchResults.size() == 1)
            selectedContact = searchResults.get(0);
        else if (searchResults.size() > 1)
            selectedContact = chooseResult();
        else
            selectedContact = null;

    }

    private Contact chooseResult() {
        showResults();
        Contact chosenContact = searchResults.get(selectResultIndex());
        return chosenContact;
    }

    private int selectResultIndex() {
        int choice;
        do
            choice = Integer.valueOf(scanner.nextLine());
        while (choice < 0 && choice >= searchResults.size());
        return choice;
    }

    private void showResults() {
        System.out.println("Here are the results please choose one:");
        for (int i = 0; i < searchResults.size(); i++)
            System.out.println(i + "- " + searchResults.get(i));
    }

    private void selectByPhoneNumber() {
        System.out.println("Phone number: ");
        String phoneNumber = scanner.nextLine();
        try {
            selectedContact = contactBook.contactByPhoneNumber(phoneNumber);
        } catch(NoSuchElementException e) {
            System.out.println("This phone number isn't in your contacts");
            selectedContact = null;
        }
    }


}
