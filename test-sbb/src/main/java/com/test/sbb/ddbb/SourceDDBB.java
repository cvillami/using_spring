package com.test.sbb.ddbb;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.boot.orm.jpa.SpringNamingStrategy;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;

@SuppressWarnings("deprecation")
@Configuration
public class SourceDDBB implements EnvironmentAware {

	@Value("${batch.jdbc.driver}")
    private String databaseDriverH2;
    @Value("${batch.jdbc.url}")
    private String databaseUrlH2;
    @Value("${batch.jdbc.user}")
    private String databaseUsernameH2;
    @Value("${batch.jdbc.password}")
    private String databasePasswordH2;
	
	@Value("${test.sbb.database.driver}")
    private String databaseDriver;
    @Value("${test.sbb.database.url}")
    private String databaseUrl;
    @Value("${test.sbb.database.username}")
    private String databaseUsername;
    @Value("${test.sbb.database.password}")
    private String databasePassword;

    private RelaxedPropertyResolver jpaPropertyResolver;
    
    @Autowired(required = false)
    private PersistenceUnitManager persistenceUnitManager;

    @Override
    public void setEnvironment(Environment environment) {
        this.jpaPropertyResolver = new RelaxedPropertyResolver(environment, "spring.jpa.");
    }

	@Bean 
	@DependsOn("jdbcTemplate")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        if (persistenceUnitManager != null) {
            entityManagerFactoryBean
                    .setPersistenceUnitManager(persistenceUnitManager);
        }
        
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan("com.test.sbb");
        entityManagerFactoryBean.getJpaPropertyMap().putAll(jpaPropertyResolver.getSubProperties("properties."));
        Map<String, Object> properties = entityManagerFactoryBean.getJpaPropertyMap();
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.ejb.naming_strategy", jpaPropertyResolver.getProperty("hibernate.naming-strategy", SpringNamingStrategy.class.getName()));
        properties.put("hibernate.hbm2ddl.auto", jpaPropertyResolver.getProperty("hibernate.ddl-auto", "none"));
        return entityManagerFactoryBean;
    }
    
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(databaseDriver);
        dataSource.setUrl(databaseUrl);
        dataSource.setUsername(databaseUsername);
        dataSource.setPassword(databasePassword);
        return dataSource;
    }

    @Bean
    @Primary
    public DataSource dataSourceH2() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(databaseDriverH2);
        dataSource.setUrl(databaseUrlH2);
        dataSource.setUsername(databaseUsernameH2);
        dataSource.setPassword(databasePasswordH2);
        return dataSource;
    }
}
