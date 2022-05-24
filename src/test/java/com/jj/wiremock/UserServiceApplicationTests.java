package com.jj.wiremock;

import com.jj.wiremock.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class UserServiceApplicationTests {
    @Autowired
    private UserController userController;


    @Test
	void controllerRunningTest() {
        assertThat(userController.getUsers().size()).isGreaterThan(0);
	}

}
