package org.payment.exceptions;

/**
 * @author caroline
 * @since 17/07/2017
 */
public class InvalidFormatException extends IllegalArgumentException {

    public InvalidFormatException(String message) {
        super(message);
    }
}
