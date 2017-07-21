package org.payment.data.repositories;

import org.payment.data.entities.CreditCardDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author caroline
 * @since 17/07/2017
 */
public interface CreditCardRepository extends CrudRepository<CreditCardDetails,Long> {
    Optional<CreditCardDetails> findById(Long creditCardId);

    CreditCardDetails findByCcNumber(String ccNumber);

}
