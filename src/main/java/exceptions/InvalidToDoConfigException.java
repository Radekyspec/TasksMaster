package exceptions;

public class InvalidToDoConfigException extends Exception {
    public InvalidToDoConfigException(String expect, String actual) {
        super("Expected: " + expect + ". Got: " + actual);
    }

    public InvalidToDoConfigException(String actual) {
        super("Got: " + actual);
    }
}
