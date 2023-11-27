package exceptions;

public class InvalidToDoPanelConfigException extends Exception {
    public InvalidToDoPanelConfigException(String expect, String actual) {
        super("Expected: " + expect + ". Got: " + actual);
    }

    public InvalidToDoPanelConfigException(String actual) {
        super("Got: " + actual);
    }
}
