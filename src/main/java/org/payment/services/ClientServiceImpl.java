package org.payment.services;

import org.payment.api.Client;
import org.payment.api.CreditCardDetails;
import org.payment.data.mappers.ModelMapper;
import org.payment.data.repositories.ClientRepository;
import org.payment.data.repositories.CreditCardRepository;
import org.payment.exceptions.ClientNotFoundException;
import org.payment.exceptions.ClientUsernameExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    private CreditCardRepository creditCardRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CreditCardDetails> getCreditCardDetailsForClient(Long clientId) throws ClientNotFoundException {
        org.payment.data.entities.Client client = clientRepository.findById(clientId).get();

        if (client == null)
            throw new ClientNotFoundException(clientId);

        return getCreditCardDetailsForClient(client);
    }

    @Override
    public List<CreditCardDetails> getCreditCardDetailsForClient(String username) throws ClientNotFoundException {
        org.payment.data.entities.Client client = clientRepository.findByUsername(username);

        if (client == null)
            throw new ClientNotFoundException(username);

        return getCreditCardDetailsForClient(client);
    }

    private List<CreditCardDetails> getCreditCardDetailsForClient(org.payment.data.entities.Client client) throws ClientNotFoundException {

        if (client != null && client.getCreditCardDetails() != null && !client.getCreditCardDetails().isEmpty() ) {
            List<CreditCardDetails> apiDetailsList = new ArrayList<>();
            for (org.payment.data.entities.CreditCardDetails details : client.getCreditCardDetails()) {
                CreditCardDetails apiDetails = new CreditCardDetails();
                modelMapper.map(details, apiDetails);
                apiDetailsList.add(apiDetails);
            }
            return apiDetailsList;
        }
        return null;
    }


    public Client createClient(Client apiClient) throws ClientUsernameExistsException {
        // Add roles to apiClient
        Set roles = new TreeSet<String>();
        roles.add(ROLE_USER);
        apiClient.setRoles(roles);

        org.payment.data.entities.Client client = clientRepository.findByUsername(apiClient.getUsername());
        if (client != null) {
           throw new ClientUsernameExistsException(apiClient.getUsername());
        }

        client = new org.payment.data.entities.Client();
        modelMapper.map(apiClient, client);
        client = clientRepository.save(client);
        modelMapper.map(client, apiClient);
        return apiClient;
    }

    @Override
    public CreditCardDetails createOrUpdateCreditCard(CreditCardDetails creditCardDetails) {

        org.payment.data.entities.CreditCardDetails creditCardDetailsSaved = creditCardRepository.findByCcNumber(creditCardDetails.getCcNumber());

        if (creditCardDetailsSaved == null) {
            creditCardDetailsSaved = new org.payment.data.entities.CreditCardDetails();
        }

        modelMapper.map(creditCardDetails, creditCardDetailsSaved);
        creditCardDetailsSaved = creditCardRepository.save(creditCardDetailsSaved);
        modelMapper.map(creditCardDetailsSaved, creditCardDetails);

        return creditCardDetails;

    }


}
