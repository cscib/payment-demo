package org.payment.data.entities;

import javax.persistence.*;

/**
 * @author caroline
 * @since 17/07/2017
 */
@Entity
@Table(name = "client_role")
public class ClientRole {

    /** The user. */
    @ManyToOne(optional = false, fetch=FetchType.EAGER)
    @JoinColumn(name="client_id",referencedColumnName = "id")
    private Client client;

    @Id
    @Column(name = "role_name")
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

        ClientRole role = (ClientRole) o;

        if (role != null ? !roleName.equals(role.roleName) : role.roleName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleName != null ? roleName.hashCode() : 0;
        return result;
    }

}
