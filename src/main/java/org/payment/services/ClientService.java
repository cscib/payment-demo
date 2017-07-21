package org.payment.services;

import org.payment.api.Client;
import org.payment.api.CreditCardDetails;
import org.payment.exceptions.ClientNotFoundException;

import java.util.List;

/**
 * @author caroline
 * @since 17/07/2017
 */
public interface ClientService {
    List<CreditCardDetails> getCreditCardDetailsForClient(Long clientId) throws ClientNotFoundException;

    List<CreditCardDetails> getCreditCardDetailsForClient(String username) throws ClientNotFoundException;

    Client createClient(Client clientDetails);

    CreditCardDetails createOrUpdateCreditCard(CreditCardDetails creditCardDetails);
}
