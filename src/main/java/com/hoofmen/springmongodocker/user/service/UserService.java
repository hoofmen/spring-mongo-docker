package com.hoofmen.springmongodocker.user.service;

import com.hoofmen.springmongodocker.user.repository.UserDAO;
import com.hoofmen.springmongodocker.user.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;

    public List<UserDAO> getUsers() {
        System.out.println("UserService got called...");
        return repo.getUsers();
    }
}
