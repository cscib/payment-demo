package org.payment.data.repositories;

import org.payment.data.entities.Client;
import org.springframework.data.repository.CrudRepository;

/**
 * @author caroline
 * @since 17/07/2017
 */
public interface ClientRepository extends CrudRepository<Client,Long> {

    Client findByUsername(String username);

    Client save(Client c);

}
