package org.payment.data.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * @author caroline
 * @since 17/07/2017
 */
@Entity
@Table(name = "credit_card_details")
public class CreditCardDetails {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "ccNumber", unique = true)
    private String ccNumber;

    @Basic
    @Column(name = "ccType")
    private String ccType;

    @Basic
    @Column(name = "expiryDate")
    private Date expiryDate;

    /** The user. */
    @ManyToOne(optional = false, fetch=FetchType.EAGER)
    @JoinColumn(name="client_id",referencedColumnName = "id")
    private Client client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreditCardDetails creditCardDetails = (CreditCardDetails) o;

        if (id != null ? !id.equals(creditCardDetails.id) : creditCardDetails.id != null) return false;
        if (ccNumber != null ? !ccNumber.equals(creditCardDetails.ccNumber) : creditCardDetails.ccNumber != null) return false;
        if (ccType != null ? !ccType.equals(creditCardDetails.ccType) : creditCardDetails.ccType != null) return false;
        if (expiryDate != null ? !expiryDate.equals(creditCardDetails.expiryDate) : creditCardDetails.expiryDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (ccNumber != null ? ccNumber.hashCode() : 0);
        result = 31 * result + (ccType != null ? ccType.hashCode() : 0);
        result = 31 * result + (expiryDate != null ? expiryDate.hashCode() : 0);
        return result;
    }


}
