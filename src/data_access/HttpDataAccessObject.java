package data_access;

import exceptions.InvalidApiKeyException;

public class HttpDataAccessObject {
    private final String API_KEY;
    public HttpDataAccessObject(String apiKey) throws InvalidApiKeyException {
        API_KEY = apiKey;
        if (!isValidApiKey()) {
            throw new InvalidApiKeyException(getApiKeyErrorMessage());
        }
    }

    private boolean isValidApiKey() {
        if (API_KEY == null || API_KEY.isEmpty() || API_KEY.isBlank()) {
            return false;
        }
        return true;
    }

    private String getApiKeyErrorMessage() {
        if (isValidApiKey()) {
            return null;
        }
        if (API_KEY == null || API_KEY.isEmpty() || API_KEY.isBlank()) {
            return "API key is empty.";
        }
        return "";
    }
}
