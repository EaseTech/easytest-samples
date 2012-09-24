package org.easetech.easytest.spring.config;

import javax.persistence.EntityManagerFactory;
import org.apache.commons.dbcp.BasicDataSource;
import org.easetech.easytest.samples.ItemService;
import org.easetech.easytest.samples.RealItemService;
import org.easetech.easytest.samples.dao.ItemDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * Create a Spring 3 Java config.
 *
 */
@Configuration
@PropertySource("classpath:/org/easetech/easytest/config/resource/jdbc.properties")
@EnableTransactionManagement()
public class BusinessConfig {
    
    /**
     * An instance of {@link ItemService} against which tests are executed.
     * @return
     */
    @Bean public ItemService itemService(){
        return new RealItemService();
    }
    
    /**
     * An instnace of {@link ItemDaoImpl} dao object
     * @return
     */
    @Bean(name="itemDao") public ItemDaoImpl daoImpl(){
        return new ItemDaoImpl();
    }
    
    /**
     * Spring provided class that wraps the properties into a user friendly Data Structure for easy consumption.
     */
    @Autowired
    Environment env;

    
    /**
     * The data source bean instance that gets its properties from jdbc.properties file
     * 
     * @return {@link BasicDataSource} instance
     */
    @Bean(name = "dataSource")
    public BasicDataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        return dataSource;
    }
    
    /**
     * JPA works with an instance of {@link EntityManagerFactory}. The LocalContainerEntityManagerFactoryBean gives full
     * control over EntityManagerFactory configuration and is appropriate for environments where fine-grained
     * customization is required. Using the LocalContainerEntityManagerFactoryBean is the most powerful JPA setup
     * option, allowing for flexible local configuration within the application. It supports links to an existing JDBC
     * DataSource, supports both local and global transactions, and so on. However, it also imposes requirements on the
     * runtime environment, such as the availability of a weaving-capable class loader if the persistence provider
     * demands byte-code transformation. Since we are using Hibernate as the JPA Provider and Hibernate does not require
     * a JVM Agent, we do not specify the loadTimeWeaving option.
     * 
     * @return EntityManagerFactory
     */
    @Bean(name = "entityManagerFactory")
    public @DependsOn({ "dataSource" })
    EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setPersistenceXmlLocation("classpath*:META-INF/persistence.xml");
        entityManagerFactory.setPersistenceUnitName(env.getProperty("jdbc.persistenceUnitName"));

        entityManagerFactory.setDataSource(dataSource());
        HibernateJpaVendorAdapter jpaAdaptor = new HibernateJpaVendorAdapter();
        jpaAdaptor.setShowSql(true);
        // This needs to be false otherwise it interferes with the loading of Data by Spring DBUnit :/
        jpaAdaptor.setGenerateDdl(true);
        jpaAdaptor.setDatabasePlatform("org.hibernate.dialect.HSQLDialect");

        entityManagerFactory.setJpaVendorAdapter(jpaAdaptor);
        // Test with package to Scan property. Remove persistence.xml
        // entityManagerFactory.setPackagesToScan("org.example.model");
        // This is the most important line as now it will not be called by Spring and we have to call it ourself
        entityManagerFactory.afterPropertiesSet();
        return entityManagerFactory.getObject();
    }
    
    /**
     * Spring JPA allows a configured JpaTransactionManager to expose a JPA transaction to JDBC access code 
     * that accesses the same JDBC DataSource, provided that the registered JpaDialect supports retrieval 
     * of the underlying JDBC Connection. Out of the box, Spring provides dialects for the Toplink, 
     * Hibernate and OpenJPA JPA implementations. 
     * @return
     */
    public @Bean(name="transactionManager") JpaTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory());
        return transactionManager;

    }


    

}
