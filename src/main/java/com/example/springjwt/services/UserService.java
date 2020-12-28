package com.example.springjwt.services;

import com.example.springjwt.model.request.UserModel;
import com.example.springjwt.model.response.ApiResponse;


public interface UserService {

     ApiResponse createUser(UserModel userModel);



}
