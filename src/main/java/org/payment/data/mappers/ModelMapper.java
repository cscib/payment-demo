package org.payment.data.mappers;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.payment.data.entities.Client;
import org.payment.data.entities.ClientRole;
import org.payment.data.entities.CreditCardDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author caroline
 * @since 17/07/2017
 */
@Component
public class ModelMapper extends ConfigurableMapper {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void configure(MapperFactory factory) {
        super.configure(factory);

        factory.registerClassMap(factory.classMap(CreditCardDetails.class, org.payment.api.CreditCardDetails.class)
                .customize(new CustomMapper<CreditCardDetails, org.payment.api.CreditCardDetails>() {
                    @Override
                    public void mapAtoB(CreditCardDetails account, org.payment.api.CreditCardDetails apiAccount, MappingContext context) {
                        apiAccount.setCcNumber(account.getCcNumber());
                        apiAccount.setCcType(account.getCcType());
                        apiAccount.setExpiryDate(account.getExpiryDate());
                        apiAccount.setUsername(account.getClient().getUsername());
                    }
                }).byDefault().toClassMap());

        factory.registerClassMap(factory.classMap(org.payment.api.CreditCardDetails.class, CreditCardDetails.class )
                .customize(new CustomMapper<org.payment.api.CreditCardDetails, CreditCardDetails>() {
                    @Override
                    public void mapAtoB(org.payment.api.CreditCardDetails apiAccount, CreditCardDetails account,   MappingContext context) {
                        account.setCcNumber(apiAccount.getCcNumber());
                        account.setCcType(apiAccount.getCcType());
                        account.setExpiryDate(apiAccount.getExpiryDate());
                    }
                }).byDefault().toClassMap());


        factory.registerClassMap(factory.classMap(Client.class, org.payment.api.Client.class)
                .customize(new CustomMapper<Client, org.payment.api.Client>() {
                    @Override
                    public void mapAtoB(Client client, org.payment.api.Client apiClient, MappingContext context) {
                        apiClient.setClientId(client.getId());
                        apiClient.setUsername(client.getUsername());
                        apiClient.setPassword(client.getPassword());

                        Set<String> apiRoles = new HashSet();
                        for (ClientRole role : client.getRoles()) {
                            apiRoles.add(role.getRoleName());
                        }
                        apiClient.setRoles(apiRoles);
                    }
                }).byDefault().toClassMap());

        factory.registerClassMap(factory.classMap( org.payment.api.Client.class, Client.class)
                .customize(new CustomMapper<org.payment.api.Client, Client>() {
                    @Override
                    public void mapAtoB(org.payment.api.Client apiClient, Client client, MappingContext context) {
                        client.setId(apiClient.getClientId());
                        client.setUsername(apiClient.getUsername());
                        client.setPassword(passwordEncoder.encode(apiClient.getPassword()));

                        Set<ClientRole> clientRoles = new HashSet();
                        for (String role : apiClient.getRoles()) {
                            ClientRole clientRole = new ClientRole();
                            clientRole.setRoleName(role);
                            clientRole.setClient(client);
                            clientRoles.add(clientRole);
                        }

                        client.setRoles(clientRoles);
                    }
                }).byDefault().toClassMap());
    }
}