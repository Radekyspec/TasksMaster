package exceptions;

public class InvalidUserConfigException extends Exception {
    public InvalidUserConfigException(String expect, String actual) {
        super("Expected: " + expect + ". Got: " + actual);
    }

    public InvalidUserConfigException(String actual) {
        super("Got: " + actual);
    }
}
