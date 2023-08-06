package com.patmat.whostalk.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean
    @Qualifier(value = "defaultDataSourceConfig")
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig defaultDataSourceConfig() {
        return new HikariConfig();
    }

    @Bean
    @Qualifier(value = "defaultDataSource")
    public DataSource dataSource() {
        return new HikariDataSource(defaultDataSourceConfig());
    }

    @Bean
    @Qualifier(value = "defaultTransactionDS")
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

}
