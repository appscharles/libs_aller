package com.appscharles.libs.aller.models.offers;

/**
 * The type Validation error.
 */
public class ValidationError {

    private String code;

    private String details;

    private String message;

    private String path;

    private String userMessage;

    /**
     * Instantiates a new Validation error.
     */
    public ValidationError() {
    }

    /**
     * Instantiates a new Validation error.
     *
     * @param code        the code
     * @param details     the details
     * @param message     the message
     * @param path        the path
     * @param userMessage the user message
     */
    public ValidationError(String code, String details, String message, String path, String userMessage) {
        this.code = code;
        this.details = details;
        this.message = message;
        this.path = path;
        this.userMessage = userMessage;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets details.
     *
     * @return the details
     */
    public String getDetails() {
        return details;
    }

    /**
     * Sets details.
     *
     * @param details the details
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets path.
     *
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets path.
     *
     * @param path the path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Gets user message.
     *
     * @return the user message
     */
    public String getUserMessage() {
        return userMessage;
    }

    /**
     * Sets user message.
     *
     * @param userMessage the user message
     */
    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }
}
