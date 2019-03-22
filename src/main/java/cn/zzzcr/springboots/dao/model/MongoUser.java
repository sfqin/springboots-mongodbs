package cn.zzzcr.springboots.dao.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "mongo_user")
public class MongoUser {

    @Id
    private String id;

    private String userAccount;

    private String userName;

    private String passwd;

    private Integer age;
}
