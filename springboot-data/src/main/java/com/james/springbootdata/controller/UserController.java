package com.james.springbootdata.controller;

import com.james.springbootdata.entity.User;
import com.james.springbootdata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    @RequestMapping("/user")
    public User insertUser(User user) {
        User saveUser = userRepository.save(user);
        return saveUser;
    }

    @ResponseBody
    @RequestMapping("/findUser/{lastName}")
    public User getUserByEmail(@PathVariable("lastName") String lastName) {
        User user2 = userRepository.findByLastName(lastName);
        return user2;
    }
}
