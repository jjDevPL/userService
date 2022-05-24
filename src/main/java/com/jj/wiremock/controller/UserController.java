package com.jj.wiremock.controller;

import com.jj.wiremock.dao.UserDao;
import com.jj.wiremock.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping ("/users")
    public List<User> getUsers() {
        return userDao.getAll();
    }

    @GetMapping("/user/{id}")
    public User getById(@PathVariable Integer id) {
        return userDao.getUser(id).orElse(new User("null user"));
    }
    @PostMapping("/user/new")
    public User addNewUser(@RequestBody User newone) {
        return userDao.addUser(newone);
    }

}
