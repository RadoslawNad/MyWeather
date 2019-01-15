package com.myweather.configuration;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:persistence-db.properties" })
public class HibernateConfig {

	@Autowired
	private Environment env;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
		sfb.setDataSource(dataSource());
		sfb.setPackagesToScan(new String[] { "com.myweather.model" });
		sfb.setHibernateProperties(hibernateProperties());

		return sfb;
	}

	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(env.getProperty("jdbc.driverClassName"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		
		//set database connection props
		dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		dataSource.setUser(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.pass"));
		
		// set connection pool props
		dataSource.setInitialPoolSize(
				getIntProperty("connection.pool.initialPoolSize"));

		dataSource.setMinPoolSize(
				getIntProperty("connection.pool.minPoolSize"));

		dataSource.setMaxPoolSize(
				getIntProperty("connection.pool.maxPoolSize"));

		dataSource.setMaxIdleTime(
				getIntProperty("connection.pool.maxIdleTime"));

		return dataSource;
	}

	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

	private Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));

		return hibernateProperties;
	}

	//parse pool connection property String to int
	private int getIntProperty(String propName) {
		String propVal = env.getProperty(propName);
		return Integer.parseInt(propVal);
	}

}
