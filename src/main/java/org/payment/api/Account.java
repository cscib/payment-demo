package org.payment.api;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author caroline
 * @since 17/07/2017
 */
public class Account  implements Serializable {

    private static final long serialVersionUID = -753253843666402299L;

    /** The account id */
    private Long accountNumber;

    /** The client id */
    private Long clientId;


    /** The description */
    @NotNull
    @NotEmpty
    private String description;

    /** The balance */
    private BigDecimal balance;

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
