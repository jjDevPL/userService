package com.jj.wiremock.dao;

import com.jj.wiremock.domain.User;
import com.jj.wiremock.exception.CommonException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.setAllowComparingPrivateFields;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@SpringBootTest()
@Transactional
@ActiveProfiles(value = "test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserDaoImplTest {
    @Autowired
    UserDao userDao;


    @Test
    void addUser() {
        User newUser = new User("nick");
        userDao.addUser(newUser);
        assertThat(newUser).isNotNull();
        assertThat(newUser.getId()).isGreaterThan(0);

        User newUser2 = new User("nick2");
        userDao.addUser(newUser2);
        assertThat(newUser2).isNotNull();
        assertThat(newUser2.getId()).isGreaterThan(1);

    }

    @Test
    void getUser() throws Exception {
        User user = new User("aaaa");
        userDao.addUser(user);
        assertThat(user.getId()).isNotNull();
        Optional<User> fromDB = userDao.getUser(user.getId());
        assertThat(fromDB.get()).isEqualTo(user);


    }

    @Test
    void getUserNotFound() {
        Optional<User> suer = userDao.getUser(-1);
        assertThat(suer.isPresent()).isFalse();
        /*userDao.getUser(user.getId());*/
    }

}
