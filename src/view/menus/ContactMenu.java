package view.menus;

import view.util.ContactMenuOption;
import view.util.MenuOption;

public class ContactMenu extends TextMenu{
    private static MenuOption[] menuOptions = {
            ContactMenuOption.RENAME_CONTACT,
            ContactMenuOption.ADD_PHONE_NUMBER,
            ContactMenuOption.REMOVE_PHONE_NUMBER,
            ContactMenuOption.DELETE_CONTACT,
            ContactMenuOption.QUIT
    };

    public ContactMenu() {
        super(menuOptions);
    }
}
