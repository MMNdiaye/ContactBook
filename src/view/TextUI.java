package view;

import storage.ContactBook;
import view.menus.MainMenu;
import view.menus.TextMenu;
import view.util.MainMenuOption;
import view.util.MenuOption;

import java.util.NoSuchElementException;

public class TextUI {
    private ContactBook contactBook;
    private TextMenu mainMenu;
    private MenuOption selectedOption;


    public TextUI() {
        contactBook = new ContactBook();
        mainMenu = new MainMenu();
    }

    public void start() {
        getOptionFromMenu();
        executeOption();
    }

    private void getOptionFromMenu() {
        try {
            selectedOption = mainMenu.chooseOption();
        } catch (NoSuchElementException e) {
            getOptionFromMenu();
        }
    }

    private void executeOption() {
        switch (selectedOption) {
            case MainMenuOption.ADD_CONTACT -> {}
            case MainMenuOption.SELECT_CONTACT -> {}
            case MainMenuOption.SHOW_CONTACTS -> {}
            case MainMenuOption.QUIT -> {}
            default -> {}
        }
    }
}
