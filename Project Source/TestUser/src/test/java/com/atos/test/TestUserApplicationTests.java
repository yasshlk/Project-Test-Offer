package com.atos.test;

import com.atos.test.controllers.UserController;
import com.atos.test.entities.User;
import com.atos.test.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class TestUserApplicationTests {
    private static final Logger logger = LogManager.getLogger(TestUserApplicationTests.class);

    @Autowired
    UserService userService;



    /**
     * Test Calling User Creating
     */
    @Test
    @Order(1)
    void testCreation() {
        User userT = new User();
        userT.setId(1L);
        userT.setFirstname("Yassine");
        userT.setLastname("Hallak");
        userT.setAge(28);
        userT.setUsername("iverson");
        userT.setEmail("yassine.hlk@mgmail.com");
        userT.setCountry("FRANCE");
        userT.setCreationDate(LocalDateTime.now());

        logger.info("Test Creation , Object to create "+ userT.toString());
        userService.createUser(userT);
    }

    /**
     * Test Calling GetUserById
     */
    @Test
    @Order(2)
    void testGetUserById() {
       //testCreation();
        User user = userService.searchUserById(1L);
        logger.info("Test Search User By Id  , Object result "+ user.toString());
    }

}
