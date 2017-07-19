package org.payment.controllers;

import org.payment.api.Client;
import org.payment.api.CreditCardDetails;
import org.payment.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by caroline on 7/17/17.
 */
public class CreditCardController {


    @Autowired
    ClientService clientService;

    /**
     * Creates credit card details
     * @param creditCardDetails - Credit card details
     * @return Created client details
     */
    @RequestMapping(value = "/creditcard", method = RequestMethod.POST)
    public Client createOrUpdateCreditCard(@Valid @RequestBody CreditCardDetails creditCardDetails) {
        return clientService.createOrUpdateCreditCard(creditCardDetails);
    }

}
