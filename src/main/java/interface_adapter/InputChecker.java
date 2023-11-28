package interface_adapter;

import java.util.regex.Pattern;

public class InputChecker {
    private InputChecker() {
    }

    public static boolean containsCapital(String input) {
        return Pattern.compile("[A-Z]").matcher(input).find();
    }

    public static boolean containsLetter(String input) {
        return Pattern.compile("[a-z]").matcher(input).find();
    }

    public static boolean containsNumber(String input) {
        return Pattern.compile("\\d").matcher(input).find();
    }

    public static boolean containsNonWord(String input) {
        return Pattern.compile("\\W").matcher(input).find();
    }

    public static boolean containsWhiteSpace(String input) {
        return Pattern.compile("\\s").matcher(input).find();
    }

    public static boolean containsValidEmail(String input) {
        return Pattern.compile(".*@.*\\..*").matcher(input).find();
    }
}
