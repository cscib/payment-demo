package org.payment.api;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.payment.data.entities.ClientRole;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * @author caroline
 * @since 17/07/2017
 */

public class Client implements Serializable {

    private static final long serialVersionUID = -2668823449501567353L;

    /** The client id */
    private Long clientId;

    @NotBlank
    /** The username */
    private String username;

    @NotBlank
    private String password;

    private Set<String> roles;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
