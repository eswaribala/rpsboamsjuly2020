package com.boa.customer.configurations;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class DbConfiguration {
	@Value("${db_url}")
	private String url;
	@Value("${db_username}")
	private String userName;
	@Value("${db_password}")
	private String password;
	@Value("${db_driver}")
	private String driver;
	private DataSourceBuilder dataSourceBuilder;
	
	@Profile("prod")
	@Bean
	public DataSource getProdDataSource()
	{
		dataSourceBuilder=DataSourceBuilder.create();
		dataSourceBuilder.username(userName);
		dataSourceBuilder.password(password);
		dataSourceBuilder.url(url);
		dataSourceBuilder.driverClassName(driver);
		log.info("Production.......");
		return dataSourceBuilder.build();
		
	}
	
	@Profile("dev")
	@Bean
	public DataSource getDevDataSource()
	{
		dataSourceBuilder=DataSourceBuilder.create();
		dataSourceBuilder.username(userName);
		dataSourceBuilder.password(password);
		dataSourceBuilder.url(url);
		dataSourceBuilder.driverClassName(driver);
		log.info("Development.......");
		return dataSourceBuilder.build();
	}
	
	@Profile("qa")
	@Bean
	public DataSource getQADataSource()
	{
		dataSourceBuilder=DataSourceBuilder.create();
		dataSourceBuilder.username(userName);
		dataSourceBuilder.password(password);
		dataSourceBuilder.url(url);
		dataSourceBuilder.driverClassName(driver);
		log.info("QA.......");
		return dataSourceBuilder.build();
	}
	
	@Profile("test")
	@Bean
	public DataSource getTestDataSource()
	{
		dataSourceBuilder=DataSourceBuilder.create();
		dataSourceBuilder.username(userName);
		dataSourceBuilder.password(password);
		dataSourceBuilder.url(url);
		dataSourceBuilder.driverClassName(driver);
		log.info("Test.......");
		return dataSourceBuilder.build();
	}

}
