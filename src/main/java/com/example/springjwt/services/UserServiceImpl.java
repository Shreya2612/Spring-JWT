package com.example.springjwt.services;


import com.example.springjwt.entity.Users;
import com.example.springjwt.model.request.UserModel;
import com.example.springjwt.model.response.ApiResponse;
import com.example.springjwt.model.response.UserResponse;
import com.example.springjwt.repo.UserRepository;
import com.example.springjwt.utility.Constants;
import com.example.springjwt.utility.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;

//logger work left

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ApiResponse createUser(UserModel userModel) {

        Users users = new Users();
        users.setFirstName(userModel.getFirstName());
        users.setLastName(userModel.getLastName());
        users.setMail(userModel.getMail());
        users.setContact(userModel.getContact());
      //  Users savedUsers = new Users();   // if I don't write it here and directly write Users savedUsers=this.userRepository.save(users); at line 32 will that work???
        try {
            String pass = userModel.getPassword();
            String salt = Utilities.generateSalt();
            String hash = Utilities.computeHash(pass, salt);
            users.setSalt(salt);
            users.setHash(hash);
          Users savedUsers = this.userRepository.save(users);

            UserResponse res = new UserResponse();
            res.setId(savedUsers.getId());

            return new ApiResponse(Arrays.asList(res),
                    Constants.MSG_CREATE_USER,
                    Constants.MSG_STATUS_SUC,
                    Constants.ErrorCodes.CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.failApiResponse(Constants.MSG_ERR_GENERIC, Constants.ErrorCodes.CODE_USER_CREATE_FAIL);
        }
    }
}
