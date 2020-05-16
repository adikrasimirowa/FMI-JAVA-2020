package validators;

public class UserNameValidator {
    public static boolean isValid(String input) {
        return input.matches("[a-zA-Z]{2,}");
    }
}
