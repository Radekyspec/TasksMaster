package exceptions;

public class InvalidApiKeyException extends Exception {
    public InvalidApiKeyException(String apiKeyErrorMessage) {
        super(apiKeyErrorMessage);
    }
}
