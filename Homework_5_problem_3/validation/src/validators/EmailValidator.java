package validators;

public class EmailValidator {
    public static boolean isValid(String input) {
        return input.matches("([a-zA-Z]+([.]|[0-9]*|[a-z]*))+[@][a-z]+[.][a-z]+");
    }
}
