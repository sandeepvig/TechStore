package com.svig.techstore.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
/**** @ComponentScan(basePackages = "com.svig") ****/
//@EnableJpaRepositories(basePackages = "com.svig")
public class AppConfig {

	@Value("${application.datasource.url}")
	private String dbUrl;
	
	@Value("${application.datasource.driver}")
	private String dbDriver;
	
	@Value("${application.datasource.username}")
	private String dbUsername;
	
	@Value("${application.datasource.password}")
	private String dbPassword;
	
	@Bean
	public DataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl(dbUrl);
		ds.setDriverClassName(dbDriver);
		ds.setUsername(dbUsername);
		ds.setPassword(dbPassword);
		ds.getConnectionInitSqls();
		return ds;
	}

	/***
	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
	    LocalEntityManagerFactoryBean localEntityManagerFactoryBean = new LocalEntityManagerFactoryBean();
	    localEntityManagerFactoryBean.setPersistenceUnitName("postgres");
	    return localEntityManagerFactoryBean;
	}
	***/
}
