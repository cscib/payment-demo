package org.payment.exceptions;

/**
 * @author caroline
 * @since 17/07/2017
 */
public class ClientNotFoundException extends IllegalArgumentException {

    public ClientNotFoundException(Long clientId) {
        super("Client with id " + clientId + "not found");
    }

}
