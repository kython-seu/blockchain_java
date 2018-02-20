package com.kason.controller;

import com.kason.dao.UserRepository;
import com.kason.entity.UserTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IBM on 2018/2/19.
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @RequestMapping("user/{id}")
    public UserTest home(@PathVariable Integer id) {
        return userRepository.findOne(id);
    }
}
