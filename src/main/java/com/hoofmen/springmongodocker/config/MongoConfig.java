package com.hoofmen.springmongodocker.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
public class MongoConfig {

    public @Bean
    MongoDbFactory mongoDbFactory() throws Exception {
        MongoClientURI mongoClientURI = new MongoClientURI("mongodb://user:user123@mongo-database:27017/thedatabase");
        MongoClient mongoClient = new MongoClient(mongoClientURI);
        return new SimpleMongoDbFactory(mongoClient,"thedatabase");
    }

    public @Bean
    MongoTemplate mongoTemplate() throws Exception {
        // To remove the _class from every insert on the collections
        MappingMongoConverter converter = new MappingMongoConverter(mongoDbFactory(), new MongoMappingContext());
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));

        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(), converter);
        return mongoTemplate;
    }
}