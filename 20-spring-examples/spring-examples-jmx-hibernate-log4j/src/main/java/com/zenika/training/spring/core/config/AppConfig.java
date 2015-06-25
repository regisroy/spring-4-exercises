package com.zenika.training.spring.core.config;

import com.zenika.training.spring.core.Log4jConfigurator;
import com.zenika.training.spring.core.repo.LettreRepository;
import com.zenika.training.spring.core.service.LaPosteBelge;
import com.zenika.training.spring.core.service.LaPosteService;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.hibernate.stat.Statistics;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.support.MBeanServerFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
//@ComponentScan("com.zenika.training.spring.core.repository")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="com.zenika.training.spring.core.repo")
//@ImportResource("com/zenika/training/spring/core/spring/application-context.xml")
public class AppConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);
        adapter.setDatabase(Database.HSQL);

        Properties props = new Properties();
        props.setProperty("hibernate.format_sql", "true");

        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(dataSource());
        emfb.setPackagesToScan("com.zenika.training.spring.core.entity");
        emfb.setJpaProperties(props);
        emfb.setJpaVendorAdapter(adapter);

        return emfb;
    }

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .addScript("classpath:testdb/schema.sql")
                .addScript("classpath:testdb/data.sql")
                .build();
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    @Bean
    public Statistics hibernateStatisticsMBean(EntityManagerFactory emf) {
        SessionFactory sessionFactory = ((HibernateEntityManagerFactory) emf).getSessionFactory();

        return sessionFactory.getStatistics();
    }

    //    <!-- Exposing Log4j over JMX -->
//    @Bean
//    public HierarchyDynamicMBean jmxLog4j() {
//        return new HierarchyDynamicMBean();
//    }

    @Bean
    public Log4jConfigurator log4jConfigurator() {
        return new Log4jConfigurator();
    }

    @Bean
    public LaPosteService laPosteService(LettreRepository lettreRepository) {
        return new LaPosteBelge(lettreRepository);
    }

    @Bean
    public MBeanServerFactoryBean mbeanServer() {
        MBeanServerFactoryBean server = new MBeanServerFactoryBean();
        server.setLocateExistingServerIfPossible(true);

        return server;
    }

    @Bean
    public MBeanExporter mbeanExporter(Statistics hibernateStatisticsMBean, LaPosteService laPosteService) {
        MBeanExporter exporter = new MBeanExporter();
        exporter.setAutodetect(true);

        Map<String, Object> beans = new HashMap<>();
        beans.put("Spring-examples-jmx:type=orm,name=hibernate-statistics", hibernateStatisticsMBean);
        beans.put("Spring-examples-jmx:type=log4jConfigurator", log4jConfigurator());
        beans.put("Spring-examples-jmx:type=laPosteService", laPosteService);
//        beans.put("Spring-example:type=log4j,name=jmxLog4j", jmxLog4j());

        exporter.setBeans(beans);

        return exporter;
    }
}
