package view.menus;

import view.util.MainMenuOption;
import view.util.MenuOption;

import java.util.NoSuchElementException;
import java.util.Scanner;

public abstract class TextMenu {
    private MenuOption[] menuOptions;
    protected static final Scanner scanner = new Scanner(System.in);

    public TextMenu(MenuOption[] menuOptions) {
        this.menuOptions = menuOptions;
    }

    private void showOptions() {
        for (MenuOption menuOption : menuOptions)
            System.out.println(menuOption);
    }

    public MenuOption chooseOption() throws NoSuchElementException {
        showOptions();
        int selectedIndex = Integer.valueOf(scanner.nextLine());
        MenuOption selectedOption = getOption(selectedIndex);
        return selectedOption;
    }

    private MenuOption getOption(int index) throws NoSuchElementException {
        for (MenuOption option : menuOptions)
            if (option.getIndex() == index)
                return option;
        throw new NoSuchElementException();
    }


}
