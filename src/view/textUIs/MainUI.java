package view.textUIs;

import view.menus.MainMenu;
import view.menus.TextMenu;

public class MainUI extends TextUI{
    private static final TextMenu menu = new MainMenu();

    public MainUI() {
        super(menu);
    }
}
