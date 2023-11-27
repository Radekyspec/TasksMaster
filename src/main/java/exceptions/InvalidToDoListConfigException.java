package exceptions;

public class InvalidToDoListConfigException extends Exception {
    public InvalidToDoListConfigException(String expect, String actual) {
        super("Expected: " + expect + ". Got: " + actual);
    }
    public InvalidToDoListConfigException(String actual) {
        super("Got: " + actual);
    }
}
