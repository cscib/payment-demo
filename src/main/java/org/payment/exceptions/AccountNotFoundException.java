package org.payment.exceptions;

/**
 * @author caroline
 * @since 17/07/2017
 */
public class AccountNotFoundException extends IllegalArgumentException {

    public AccountNotFoundException(Long accountId) {
        super("Account with id " + accountId + "not found");
    }

}
