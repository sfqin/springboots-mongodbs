package cn.zzzcr.springboots.dao.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import lombok.Data;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Data
public abstract class AbstractMongoConfig {

    private String database;
    private String host;
    private String password;
    private int    port;
    private String username;
    private String authDatabase;


    public MongoDbFactory mongoDbFactory(){
        MongoCredential credential = MongoCredential.createCredential(
                username,
                authDatabase,
                password.toCharArray());

        MongoClient mongoClient = new MongoClient(
                new ServerAddress(host,port),
                credential,
                MongoClientOptions.builder().build());

        return new SimpleMongoDbFactory(mongoClient,database);

    }

    public abstract MongoTemplate getMongoTemplate();
}
