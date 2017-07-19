package org.payment.data.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * @author caroline
 * @since 17/07/2017
 */
@Entity
@Table(name = "client")
public class Client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "username")
    private String username;

    @Basic
    @Column(name = "password")
    private String password;

    @OneToMany(targetEntity=ClientRole.class, fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="client")
    private Set<ClientRole> roles;

    @OneToMany(targetEntity=CreditCardDetails.class, fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="client")
    private Set<CreditCardDetails> creditCardDetails;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (id != null ? !id.equals(client.id) : client.id != null) return false;
        if (username != null ? !username.equals(client.username) : client.username != null) return false;
        if (password != null ? !password.equals(client.password) : client.password != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    public Set<CreditCardDetails> getCreditCardDetails() {
        return creditCardDetails;
    }

    public void setCreditCardDetails(Set<CreditCardDetails> creditCardDetails) {
        this.creditCardDetails = creditCardDetails;
    }

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    public Set<ClientRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<ClientRole> roles) {
        this.roles = roles;
    }
}
