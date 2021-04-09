package org.demo.app.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
// @EntityScan(basePackages = "org.demo.app.domain")
// @EnableJpaRepositories(basePackages = "org.demo.app.repos")
@EntityScan(basePackages = "org.demo.app.persistence.jpa")
@EnableJpaRepositories(basePackages = "org.demo.app.persistence.jpa")
@EnableTransactionManagement
public class DomainConfig {
}
