package util;

public class NonUniquePhoneNumberException extends RuntimeException{

    public NonUniquePhoneNumberException() {
        super("This phone number is not unique");
    }
}
