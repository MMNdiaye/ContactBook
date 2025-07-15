package view.util;

public enum ContactMenuOption implements MenuOption{
    RENAME_CONTACT(1, "Rename contact"),
    ADD_PHONE_NUMBER(2, "Add phone number"),
    REMOVE_PHONE_NUMBER(3, "Remove a phone number"),
    DELETE_CONTACT(4, "Delete the contact"),
    QUIT(0, "Quit");

    private int index;
    private String text;

    ContactMenuOption(int index, String text){
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
