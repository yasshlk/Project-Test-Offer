package com.atos.test.controllers;


import com.atos.test.entities.User;
import com.atos.test.exceptions.UserValidationExistsException;
import com.atos.test.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

/* Created By yassine */

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);
    @Autowired
    UserService userService;


    /**
     *
     * @param user
     * @param bindingResult
     * @return
     */

    @PostMapping("/create")
    ResponseEntity<User>  createUser(@Valid @RequestBody User user, BindingResult bindingResult){
        logger.trace("User Controller "+ LocalDateTime.now()," User Creation Call Object Received : " + user.toString());
        if (bindingResult.hasErrors()) {
            logger.warn("Functional Error On Creation "+ LocalDateTime.now()," Field Validation Error");

            throw new UserValidationExistsException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/getuserbyid/{id}")
    ResponseEntity getUserById(@PathVariable("id") Long id){
        logger.trace("User Controller  "+ LocalDateTime.now()," User search Id  : " + id );
        return new ResponseEntity<User>(userService.searchUserById(id), HttpStatus.OK);
    }


}
