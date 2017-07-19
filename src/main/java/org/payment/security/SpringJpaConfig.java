package org.payment.security;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

/**
 * @author caroline
 * @since 17/07/2017
 */

@Configuration
public class SpringJpaConfig {

    @Autowired
    private LocalContainerEntityManagerFactoryBean entityManagerFactory;

    @Bean
    public JpaTransactionManager txManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory.getObject());
        return transactionManager;
    }

    @Bean
    public SessionFactory sessionFactory(HibernateEntityManagerFactory hibernateEntityManagerFactory) {
        return hibernateEntityManagerFactory.getSessionFactory();
    }

}
