package cn.zzzcr.springboots.controller;

import cn.zzzcr.springboots.dao.model.MongoUser;
import cn.zzzcr.springboots.dao.model.MongoUser1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/rest")
public class UserController {




//========================mongodb多数据源测试接口=================================

    @Autowired
    @Qualifier("mongo1")
    private MongoTemplate mongoTemplate1;

    @Autowired
    @Qualifier("mongo2")
    private MongoTemplate mongoTemplate2;


    @GetMapping("accounts")
    public Map<String,Object> getUsersByAccount(String account){
        Query query = new Query(Criteria.where("userAccount").is(account));
        MongoUser one = mongoTemplate1.findOne(query, MongoUser.class);

        MongoUser1 one1 = mongoTemplate2.findOne(query, MongoUser1.class);

        Map<String,Object> result = new HashMap<>();
        result.put("mongoTemplate1",one);
        result.put("mongoTemplate2",one1);


        return result;
    }

//========================mongodb多数据源测试接口=================================
}
