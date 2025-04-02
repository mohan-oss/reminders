package com.reminder.configuration;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
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
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories( basePackages = "com.reminder.dao.app"
        ,entityManagerFactoryRef = "mysqlEntityManager"
        ,transactionManagerRef = "mysqlTransactionManager"
)
public class AppDataBaseConfig implements ApplicationRunner {

    @Bean
    @ConfigurationProperties("spring.datasource.app")
    public DataSourceProperties appDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    public DataSource appDataSource(){
        return appDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder() {
        return new EntityManagerFactoryBuilder(
                new org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter(),
                new HashMap<>(),
                null
        );
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean mysqlEntityManager(EntityManagerFactoryBuilder entityManagerFactoryBuilder){
        LocalContainerEntityManagerFactoryBean build = entityManagerFactoryBuilder.dataSource(appDataSource())
                .packages("com.reminder.entity.app").build();
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        build.setJpaPropertyMap(properties);
        return build;
    }
    @Bean
    public TransactionManager mysqlTransactionManager(EntityManagerFactory mysqlEntityManager){
        return new JpaTransactionManager(mysqlEntityManager);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Inside DataBaseConfig");
    }
}
