package org.payment.services;

import org.payment.api.Account;
import org.payment.api.Client;
import org.payment.api.CreditCardDetails;
import org.payment.exceptions.AccountNotFoundException;
import org.payment.exceptions.ClientNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author caroline
 * @since 17/07/2017
 */
@Service
public class ClientServiceImpl implements ClientService{


    public Client getClient(Long cientId) throws ClientNotFoundException{
        return null;
    }

    @Override
    public List<CreditCardDetails> getCreditCardDetailsForClient(Long clientId) throws ClientNotFoundException {
        return null;
    }


    public Client createClient(Client clientDetails){
        return null;
    }

    @Override
    public Client createOrUpdateCreditCard(CreditCardDetails creditCardDetails) {
        return null;
    }


}
