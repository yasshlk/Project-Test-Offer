package com.atos.test.services;

import com.atos.test.entities.User;
import com.atos.test.exceptions.UserValidationExistsException;
import com.atos.test.exceptions.UserNotFoundException;
import org.springframework.stereotype.Component;

/* Created By yassine */

@Component
public interface UserService {

    User createUser(User user) throws UserValidationExistsException;
    User searchUserById(Long id) throws UserNotFoundException;

}
