package com.example.springjwt.services;

import com.example.springjwt.model.response.ApiResponse;

public interface LoginService {


    ApiResponse login(String username, String password) ;
}
