package view.menus;


import view.util.MainMenuOption;
import view.util.MenuOption;

public class MainMenu extends TextMenu {
    private static MenuOption[] menuOptions = {
            MainMenuOption.ADD_CONTACT,
            MainMenuOption.SELECT_CONTACT,
            MainMenuOption.SHOW_CONTACTS,
            MainMenuOption.QUIT
    };

    MainMenu() {
        super(menuOptions);
    }
}
