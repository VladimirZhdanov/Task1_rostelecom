package ru.rostelecom.configs;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.rostelecom.dao.ExecutorQuery;
import ru.rostelecom.dao.layers.*;
import ru.rostelecom.dao.oracle.*;
import ru.rostelecom.model.Tsveta;
import ru.rostelecom.service.*;
import ru.rostelecom.service.layers.*;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */

@Configuration
@PropertySource("classpath:/properties/oracle.properties")
public class SpringConfig {

    @Value("${oracle.url}")
    private String url;
    @Value("${oracle.username}")
    private String username;
    @Value("${oracle.password}")
    private String password;
    @Value("${oracle.driverClassName}")
    private String driver;

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(oracle.jdbc.driver.OracleDriver.class.getName());
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public ExecutorQuery executorQuery() {
        return new ExecutorQuery(getDataSource());
    }

    @Bean
    public TsvetaDAO tsvetaDAO() {
        return new TsvetaOracle(getDataSource());
    }

    @Bean
    public TsvetaService tsvetaService() {
        return new TsvetaServiceImp(tsvetaDAO());
    }

    @Bean
    public Tsveta tsveta() {
        return new Tsveta();
    }
}
