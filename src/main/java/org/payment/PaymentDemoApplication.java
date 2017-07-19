package org.payment;


import org.payment.security.MvcConfiguration;
import org.payment.security.SpringJpaConfig;
import org.payment.security.WebSecurityConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author caroline
 * @since 17/07/2017
 */
@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories(transactionManagerRef = "txManager", entityManagerFactoryRef = "entityManagerFactory")
@Import({SpringJpaConfig.class, WebSecurityConfig.class, MvcConfiguration.class})
public class PaymentDemoApplication {

    private static final Logger logger = LoggerFactory.getLogger(PaymentDemoApplication.class);


    public static void main(String[] args) {
        logger.info("Main application STARTED");
        SpringApplication.run(PaymentDemoApplication.class, args);
    }
}
