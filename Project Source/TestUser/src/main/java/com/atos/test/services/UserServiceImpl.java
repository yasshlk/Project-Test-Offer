package com.atos.test.services;

import com.atos.test.dao.UserRepository;
import com.atos.test.entities.User;
import com.atos.test.exceptions.UserValidationExistsException;
import com.atos.test.exceptions.UserNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/* Created By yassine */

@Service
public class UserServiceImpl implements UserService{
    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    /**
     *
     * @param user
     * @return
     */
    @Override
    public User createUser(User user) {
        List<User> userResults = userRepository.findUsersByEmail(user.getEmail());
        if(userResults.size() != 0) {
            logger.warn(" Existing Email error");
            throw new UserValidationExistsException("User With This Email Already Exists ");
        }else if( !user.getCountry().equals("FRANCE")){
            logger.warn("Invalid Country");
            throw new UserValidationExistsException("Only France is allowed on country");
        }
        else
            user.setCreationDate(LocalDateTime.now());
             return userRepository.save(user);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public User searchUserById(Long id) {
       return userRepository.findAll().stream().filter((user)-> user.getId()== id)
               .findAny().orElseThrow(()-> new UserNotFoundException());
    }

}
