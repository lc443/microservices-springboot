package com.leron.user.controller;

import com.leron.user.model.User;
import com.leron.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User save( @RequestBody User user) {
        log.info("Inside save user of user controller");
        return userService.save(user);
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long id) {
        log.info("Inside find by Id of user controller");
        return userService.findUserById(id);
    }

    @GetMapping
    public List<User> findAllUsers() {
        log.info("Inside find all users of controller");
        return userService.findAllUsers();
    }

}
