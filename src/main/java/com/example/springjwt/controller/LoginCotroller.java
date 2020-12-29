package com.example.springjwt.controller;

import com.example.springjwt.model.response.ApiResponse;
import com.example.springjwt.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")

public class LoginCotroller {

    @Autowired

    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ApiResponse login(@RequestParam("username") String username, @RequestParam("password") String password) {
    return this.loginService.login(username, password);
    }


}
