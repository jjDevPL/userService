package com.jj.wiremock.dao;

import com.jj.wiremock.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    User addUser(User user);
    Optional<User> getUser(Integer id) ;
    List<User> getAll();
}
