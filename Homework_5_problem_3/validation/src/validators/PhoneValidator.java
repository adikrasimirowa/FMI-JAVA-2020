package validators;

public class PhoneValidator {
    public static boolean isValid(String input) {
        return input.matches("[(][0-9]{4}[)][ ][(][0-9]{7}[)]");
    }
}
