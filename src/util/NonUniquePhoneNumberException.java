package util;

import java.util.List;
import java.util.Set;

public class NonUniquePhoneNumberException extends RuntimeException{

    public NonUniquePhoneNumberException() {
        super("There are non unique phone numbers");
    }

    public NonUniquePhoneNumberException(Set<String> phoneNumbers) {
        super("These phone numbers " + phoneNumbers + " are not unique");
    }

}
