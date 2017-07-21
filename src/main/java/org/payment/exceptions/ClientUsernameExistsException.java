package org.payment.exceptions;

/**
 * @author caroline
 * @since 17/07/2017
 */
public class ClientUsernameExistsException extends IllegalArgumentException {

    public ClientUsernameExistsException(String username) {
        super("Client with username " + username + " already exists");
    }

}
