package view.textUIs;

import model.Contact;
import storage.ContactBook;
import view.menus.ContactMenu;
import view.menus.TextMenu;
import view.util.ContactMenuOption;
import view.util.MainMenuOption;
import view.util.MenuOption;

import java.util.NoSuchElementException;
import java.util.Scanner;

public abstract class TextUI {
    protected static ContactBook contactBook = new ContactBook();
    protected static final Scanner scanner = new Scanner(System.in);
    private TextMenu menu;
    private MenuOption selectedOption;
    protected  static Contact selectedContact;
    private boolean isExited;

    public TextUI() {

    }

    public TextUI(TextMenu menu) {
       this.menu = menu;
    }

    public void start() {
        while (true) {
            getOptionFromMenu();
            executeOption();
            if (isExited)
                break;
        }
    }

    private void getOptionFromMenu() {
        try {
            selectedOption = menu.chooseOption();
        } catch (NoSuchElementException e) {
            getOptionFromMenu();
        }
    }


    private void executeOption() {
        switch (selectedOption) {
            case MainMenuOption.ADD_CONTACT -> new ContactCreationUI().start();

            case MainMenuOption.SELECT_CONTACT -> {
                selectContact();
                showContactOptions();
            }

            case MainMenuOption.SHOW_CONTACTS -> showContacts();

            case MainMenuOption.QUIT, ContactMenuOption.QUIT -> isExited = true;

            case ContactMenuOption.RENAME_CONTACT ->
                    new ContactModificationUI().rename();

            case ContactMenuOption.ADD_PHONE_NUMBER ->
                    new ContactModificationUI().addPhoneNumber();

            case ContactMenuOption.REMOVE_PHONE_NUMBER ->
                new ContactModificationUI().removePhoneNumber();

            case ContactMenuOption.DELETE_CONTACT -> {
                new ContactModificationUI().deleteContact();
                isExited = true;
            }

            default -> {}
        }
        showContactIfSelected();
    }

    private void showContactIfSelected() {
        if (selectedContact != null)
            System.out.println("Contact: " + selectedContact);
    }

    private void selectContact() {
        ContactSelectionUI contactSelectionUI = new ContactSelectionUI();
        contactSelectionUI.start();
    }

    private void showContactOptions() {
        if (selectedContact != null)
            new ContactUI(selectedContact).start();

    }

    private void showContacts() {
        System.out.println("Contact Book:");
        System.out.println(contactBook.getAllContacts());
    }
}
