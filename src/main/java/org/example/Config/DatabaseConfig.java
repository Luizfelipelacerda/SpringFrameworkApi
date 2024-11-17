package org.example.Config;

//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//import java.util.Properties;

//@Configuration
//@EnableJpaRepositories(basePackages = "org.example.Repository")
public class DatabaseConfig {

//    @Bean
//    public DataSource dataSource(){
//        HikariDataSource dataSource = new HikariDataSource();
//        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/db");
//        dataSource.setUsername("root");
//        dataSource.setPassword("91718321");
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        return dataSource;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource){
//        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();;
//        emf.setDataSource(dataSource);
//        emf.setPackagesToScan("org.example.Model");
//        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//
//        Properties jpaProperties = new Properties();
//        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//        jpaProperties.put("hibernate.dialect.storage_engine", "innodb");
//        jpaProperties.put("hibernate.hbm2ddl.auto", "update");
//        jpaProperties.put("hibernate.show_sql", "true");
//        emf.setJpaProperties(jpaProperties);
//        return emf;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(emf);
//        return transactionManager;
//    }

}
