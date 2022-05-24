package com.jj.wiremock.config;

import com.jj.wiremock.dao.UserDao;
import com.jj.wiremock.domain.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Configuration
@Profile(value = "!test")
public class DbSetup {
    private UserDao userDao;

    public DbSetup(UserDao userDao) {
        this.userDao = userDao;
    }
    @PostConstruct
    public void setUp() {
        User newUser= new User("nick");
        userDao.addUser(newUser);
        User newUser2= new User("nick2");
        userDao.addUser(newUser2);
    }
}
