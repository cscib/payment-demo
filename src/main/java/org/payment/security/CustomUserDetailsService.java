package org.payment.security;

import org.payment.data.entities.Client;
import org.payment.data.entities.ClientRole;
import org.payment.data.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author caroline
 * @since 17/07/2017
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    @Transactional
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        //log.info(String.format("User Credentials loading from DB: %s", userCredentials));
        System.out.println("User Credentials loading from DB");

        Client user = clientRepository.findByUsername(username);
        if (user == null) {
            return null;
        }

        for (ClientRole role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return new User(user.getUsername(), user.getPassword(), authorities);
    }

}
