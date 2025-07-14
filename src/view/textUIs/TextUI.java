package view.textUIs;

import storage.ContactBook;
import view.menus.TextMenu;
import view.util.MainMenuOption;
import view.util.MenuOption;

import java.util.NoSuchElementException;
import java.util.Scanner;

public abstract class TextUI {
    protected static ContactBook contactBook = new ContactBook();
    protected static final Scanner scanner = new Scanner(System.in);
    private TextMenu menu;
    private MenuOption selectedOption;
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
            case MainMenuOption.SELECT_CONTACT -> {}
            case MainMenuOption.SHOW_CONTACTS -> {}
            case MainMenuOption.QUIT -> isExited = true;
            default -> {}
        }
    }
}
