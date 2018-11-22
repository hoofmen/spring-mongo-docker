package com.hoofmen.springmongodocker.user.repository;


import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRepo {

    @Autowired
    private MongoTemplate mongoTemplate;


    public List<UserDAO> getUsers() {
        System.out.println("UserRepo got called...");
        List<UserDAO> userList;
        try {
            userList = mongoTemplate.findAll(UserDAO.class);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        if (CollectionUtils.isEmpty(userList)) {
            System.out.println("Collection empty!");
        }
        return userList;
    }

}
