package validators;

public class PasswordValidator {

    public static boolean isValid(String input) {
        return input.matches("[a-zA-Z]{4}[0-9]{3}");
    }
}
