package com.helper.finance.configuration;

import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by Dmitriy Vasiliev on 01.10.2015.
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.helper.finance.model.mongodb.repository")
public class SpringMongoConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {

        return "financeHelper";
    }

    @Override
    @Bean
    public MongoClient  mongo() throws Exception {
        MongoClient client = new MongoClient("127.0.0.1");
        client.setWriteConcern(WriteConcern.SAFE);
        return client;
    }

    @Override
    protected String getMappingBasePackage() {
        return "com.helper.finance.model.mongodb";
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), getDatabaseName());
    }
}
