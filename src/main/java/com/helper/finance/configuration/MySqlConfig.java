package com.helper.finance.configuration;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Dmitriy Vasiliev on 15.10.2015.
 */
@Configuration
@Qualifier("mySqlConfig")
public class MySqlConfig {

    @Autowired
    Properties dbProperties;

    @Bean
    DataSource mySqlDataSource(){

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(dbProperties.getProperty("db.url"));
        dataSource.setUser(dbProperties.getProperty("db.username"));
        dataSource.setPassword(dbProperties.getProperty("db.password"));

        return dataSource;
    }
}
