package org.payment.controllers;


import org.payment.api.Account;
import org.payment.api.Client;
import org.payment.api.CreditCardDetails;
import org.payment.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author caroline
 * @since 17/07/2017
 */
@RestController
@RequestMapping("/api/payment-system")
public class ClientController {

    @Autowired
    ClientService clientService;

    /**
     * Creates a client in the Payment system
     * @param client - Client details required for registration
     * @return Created client details
     */
    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    public Client createClient(@Valid @RequestBody Client client) {
        return clientService.createClient(client);
    }


    /**
     * Returns a client for a given client id
     * @param clientId - Client id which to retrieve
     * @return Client Details within the system
     */
    @RequestMapping(value = "/clients/{clientId}", method = RequestMethod.GET)
    public Client getClient(@PathVariable Long clientId) {
        return clientService.getClient(clientId);
    }

    /**
     * Returns all the accounts for a given client id
     * @param clientId - Client id with which to search for
     * @return List of accounts for the given client
     */
    @RequestMapping(value = "/clients/{clientId}/creditcarddetails", method = RequestMethod.GET)
    public List<CreditCardDetails> getClientCreditCardDetails(@PathVariable Long clientId) {
        return clientService.getCreditCardDetailsForClient(clientId);
    }
}
