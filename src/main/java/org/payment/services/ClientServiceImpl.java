package org.payment.services;

import org.payment.api.Account;
import org.payment.api.Client;
import org.payment.api.CreditCardDetails;
import org.payment.data.mappers.ModelMapper;
import org.payment.data.repositories.ClientRepository;
import org.payment.exceptions.AccountNotFoundException;
import org.payment.exceptions.ClientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author caroline
 * @since 17/07/2017
 */
@Service
public class ClientServiceImpl implements ClientService{

    public static final String ROLE_USER = "ROLE_USER";
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Client getClient(Long cientId) throws ClientNotFoundException{
        return null;
    }

    @Override
    public List<CreditCardDetails> getCreditCardDetailsForClient(Long clientId) throws ClientNotFoundException {
        return null;
    }


    public Client createClient(Client apiClient){
        org.payment.data.entities.Client client = new org.payment.data.entities.Client();

        Set roles = new TreeSet<String>();
        roles.add(ROLE_USER);
        apiClient.setRoles(roles);
        modelMapper.map(apiClient, client);
        client = clientRepository.save(client);
        modelMapper.map(client, apiClient);
        return apiClient;
    }

    @Override
    public Client createOrUpdateCreditCard(CreditCardDetails creditCardDetails) {
        return null;
    }


}
