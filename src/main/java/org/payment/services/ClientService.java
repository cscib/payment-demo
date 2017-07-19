package org.payment.services;

import org.payment.api.Account;
import org.payment.api.Client;
import org.payment.api.CreditCardDetails;
import org.payment.exceptions.AccountNotFoundException;
import org.payment.exceptions.ClientNotFoundException;

import java.util.List;

/**
 * @author caroline
 * @since 17/07/2017
 */
public interface ClientService {
    Client getClient(Long cientId) throws ClientNotFoundException;

    List<CreditCardDetails> getCreditCardDetailsForClient(Long clientId) throws ClientNotFoundException;

    Client createClient(Client clientDetails);

    Client createOrUpdateCreditCard(CreditCardDetails creditCardDetails);
}
