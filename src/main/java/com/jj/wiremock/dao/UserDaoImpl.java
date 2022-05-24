package com.jj.wiremock.dao;

import com.jj.wiremock.domain.User;
import com.jj.wiremock.exception.CommonException;
import com.jj.wiremock.repository.UserRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
@Component
public class UserDaoImpl implements UserDao {
    private UserRepository userRepository;
    public UserDaoImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUser(Integer id) {
            return  userRepository.findById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
