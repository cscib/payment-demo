package org.payment.data.repositories;

import org.payment.data.entities.CreditCardDetails;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author caroline
 * @since 17/07/2017
 */
public interface CreditCardRepository extends CrudRepository<CreditCardDetails,Long> {
    //Locking the account row for updating to prevent conflicts
    //@Query(value = "SELECT * FROM credit_card_details a WHERE a.id=?1 FOR UPDATE", nativeQuery= true)
    Optional<CreditCardDetails> findById(Long creditCardId);

    CreditCardDetails findByCcNumber(String ccNumber);
}
