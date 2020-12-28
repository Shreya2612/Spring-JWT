package com.example.springjwt.controller;

import com.example.springjwt.model.request.UserModel;
import com.example.springjwt.model.response.ApiResponse;
import com.example.springjwt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")


public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public ApiResponse create(@RequestBody UserModel userModel) {
        return this.userService.createUser(userModel);
    }


}
