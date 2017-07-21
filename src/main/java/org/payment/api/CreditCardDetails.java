package org.payment.api;

import org.payment.data.entities.*;
import org.payment.data.entities.Client;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author caroline
 * @since 17/07/2017
 */
public class CreditCardDetails  implements Serializable {


    private static final long serialVersionUID = 3307171249247060887L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull(message = "Invalid credit card number")
    private String ccNumber;

    @Column
    @NotNull(message = "Credit card type cannot be empty")
    private String ccType;

    @NotNull(message = "Invalid credit card expiry date")
    @DateTimeFormat(pattern="MM/yyyy")
    @Future(message = "Credit card is expired")
    private Date expiryDate;

    @NotNull
    private Client client;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public String getCcType() {
        return ccType;
    }

    public void setCcType(String ccType) {
        this.ccType = ccType;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
