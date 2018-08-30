package com.appscharles.libs.aller.exceptions;

/**
 * The type Aller exception.
 */
public class AllerException extends Exception {

    // Code is null. [0001-000]

    /**
     * The Serial version uid.
     */
    static final long serialVersionUID = 7231375821126530432L;

    /**
     * Instantiates a new Aller exception.
     */
    public AllerException() {
        super();
    }

    /**
     * Instantiates a new Aller exception.
     *
     * @param message the message
     */
    public AllerException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Aller exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public AllerException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Aller exception.
     *
     * @param cause the cause
     */
    public AllerException(Throwable cause) {
        super(cause);
    }

}

