package pl.adambaranowski.config;


import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Configuration
public class JpaConfiguration {

    @Bean
    public LocalContainerEntityManagerFactoryBean createEMF(JpaVendorAdapter jpaVendorAdapter, DataSource ds){
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setPersistenceUnitName("spring-jpa-pu");
        emf.setDataSource(ds);
        emf.setJpaVendorAdapter(jpaVendorAdapter);
        emf.setPackagesToScan("pl.adambaranowski");
        return emf;
    }

    @Bean
    public JpaVendorAdapter createVendorAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        return adapter;
    }

    @Bean
    public DataSource createDS(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/librajpa?useSSL=false&serverTimezone=UTC");
        ds.setUsername("root");
        ds.setPassword("Puci@k");
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setInitialSize(5);
        return ds;
    }
}
