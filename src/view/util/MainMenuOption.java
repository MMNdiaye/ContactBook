package view.util;

public enum MainMenuOption implements MenuOption{
    ADD_CONTACT(1, "Add a new contact"),
    SELECT_CONTACT(2, "Select a contact"),
    SHOW_CONTACTS(3, "Show all contacts"),
    DELETE_CONTACT (4, "Delete a contact"),
    QUIT(0, "Quit");


    int index;
    String text;

    MainMenuOption(int index, String text) {
        this.index = index;
        this.text = text;
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return index + "- " + text;
    }
}
