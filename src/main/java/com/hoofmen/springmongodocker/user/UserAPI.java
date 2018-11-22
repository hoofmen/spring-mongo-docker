package com.hoofmen.springmongodocker.user;

import com.hoofmen.springmongodocker.user.repository.UserDAO;
import com.hoofmen.springmongodocker.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserAPI {
    @Autowired
    private UserService service;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public @ResponseBody
    List<UserDAO> getById() {
        System.out.println("UserAPI got called...");
        return service.getUsers();
    }
}
