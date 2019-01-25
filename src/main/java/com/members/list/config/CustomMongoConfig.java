package com.members.list.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class CustomMongoConfig extends AbstractMongoConfiguration {

    @Value("${default.mongo.uri}")
    private String defaultMongoUri;

    @Value("${default.mongo.dbname}")
    private String defaultMongoDbname;

    @Override
    public MongoClient mongoClient() {
        if (System.getenv("mongo_uri") != null && System.getenv("mongo_uri").lastIndexOf("/") != -1) {
            String uri = System.getenv("mongo_uri").substring(0, System.getenv("mongo_uri").lastIndexOf("/"));
            return new MongoClient(new MongoClientURI(uri));
        } else {
            return new MongoClient(defaultMongoUri);
        }

    }

    @Override
    protected String getDatabaseName() {
        if (System.getenv("mongo_uri") != null && System.getenv("mongo_uri").lastIndexOf("/") != -1) {
            String databaseName = System.getenv("mongo_uri").substring(System.getenv("mongo_uri").lastIndexOf("/") + 1);
            return databaseName;
        } else {
            return defaultMongoDbname;
        }
    }
}