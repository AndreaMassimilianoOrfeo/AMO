package it.gov.mef.cuconverter.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource(value = { "classpath:conf.properties" })
public class AppConfig {
	
	@Autowired
    private Environment env;
 
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("batch.jdbc.driver"));
        dataSource.setUrl(env.getRequiredProperty("batch.jdbc.url"));
        dataSource.setUsername(env.getRequiredProperty("batch.jdbc.username"));
        dataSource.setPassword(env.getRequiredProperty("batch.jdbc.password"));
        return dataSource;
    }
 
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        return jdbcTemplate;
    }
    
    public String getConfPropertiesVale(String key)
    {
    	return env.getProperty(key);
    }

}


