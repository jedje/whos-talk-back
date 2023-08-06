package com.patmat.whostalk.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MybatisConfig {
    @Value("${mybatis.mapper-locations}")
    private String mapperLocation;

    @Value("${mybatis.type-aliases-package}")
    private String typeAliasPackage;

    @Bean(name = "defaultSqlSessionFactory")
    public SqlSessionFactory defaultSqlSessionFactory(
            @Qualifier("defaultDataSource") DataSource defaultDataSource,
                                                    ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(defaultDataSource);
        sqlSessionFactoryBean.setTransactionFactory(new SpringManagedTransactionFactory());
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources(mapperLocation));
        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasPackage);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "defaultSqlSessionTemplate")
    public SqlSessionTemplate defaultSqlSessionTemplate(@Qualifier("defaultSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
