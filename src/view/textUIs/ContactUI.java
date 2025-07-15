package view.textUIs;

import model.Contact;
import view.menus.ContactMenu;
import view.menus.TextMenu;
import view.util.ContactMenuOption;
import view.util.MenuOption;

public class ContactUI extends TextUI{
    private static final TextMenu menu = new ContactMenu();

    ContactUI(Contact contact) {
        super(menu);
    }

}
