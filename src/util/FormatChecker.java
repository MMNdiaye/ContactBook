package util;

public abstract class FormatChecker {
    private static String phonePattern = "(\\(\\+\\d{3}\\) )?\\d{7,9}";

    public static boolean checkPhoneNumber(String phoneNumber) {
        return phoneNumber.matches(phonePattern);
    }
}
