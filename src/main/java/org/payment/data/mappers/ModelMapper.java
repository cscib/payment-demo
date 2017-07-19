package org.payment.data.mappers;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

/**
 * @author caroline
 * @since 17/07/2017
 */
@Component
public class ModelMapper extends ConfigurableMapper {

    public void configure(MapperFactory factory) {
        super.configure(factory);

//        factory.registerClassMap(factory.classMap(CreditCardDetails.class, org.payment.api.CreditCardDetails.class)
//                .customize(new CustomMapper<CreditCardDetails, org.payment.api.CreditCardDetails>() {
//                    @Override
//                    public void mapAtoB(CreditCardDetails account, org.payment.api.CreditCardDetails apiAccount, MappingContext context) {
//                        apiAccount.setAccountNumber(account.getId());
//                    }
//                }).byDefault().toClassMap());
//
//
//        factory.registerClassMap(factory.classMap(Client.class, org.payment.api.Client.class)
//                .customize(new CustomMapper<Client, org.payment.api.Client>() {
//                    @Override
//                    public void mapAtoB(Client client, org.payment.api.Client apiClient, MappingContext context) {
//                        apiClient.setClientId(client.getId());
//                        apiClient.setName(client.getClientUsername());
//                        apiClient.setSurname(client.getClientPassword());
//                    }
//                }).byDefault().toClassMap());
//
//
    }
}