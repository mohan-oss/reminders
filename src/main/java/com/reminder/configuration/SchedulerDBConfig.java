package com.reminder.configuration;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.reminder.dao.scheduler"
        ,entityManagerFactoryRef = "schedulerEntityManagerFactory"
        ,transactionManagerRef = "schedulerTransactionManager"
)
public class SchedulerDBConfig {
    @Bean
    @ConfigurationProperties("spring.datasource.scheduler")
    public DataSourceProperties schedulerDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    public DataSource schedulerDataSource(){
        return schedulerDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean schedulerEntityManagerFactory(EntityManagerFactoryBuilder entityManagerFactoryBuilder){
        return entityManagerFactoryBuilder.dataSource(schedulerDataSource())
                .packages("src.main.java.com.reminder.entity.scheduler")
                .properties(Map.of("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect"))
                .build();
    }

    @Bean
    public TransactionManager schedulerTransactionManager(EntityManagerFactory schedulerEntityManagerFactory){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(schedulerEntityManagerFactory);
        return jpaTransactionManager;
    }
}
