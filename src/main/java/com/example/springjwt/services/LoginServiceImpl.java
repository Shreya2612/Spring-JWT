package com.example.springjwt.services;


import com.example.springjwt.entity.Users;
import com.example.springjwt.model.response.ApiResponse;
import com.example.springjwt.repo.LoginRepository;
import com.example.springjwt.repo.UserRepository;
import com.example.springjwt.utility.Utilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    private static final Logger LOG = LoggerFactory.getLogger(LoginServiceImpl.class);  //for logger

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoginRepository loginRepository;

    @Override
    public ApiResponse login(String username, String password) {

        Optional<Users> userOpt = this.userRepository.findOne((root, criteriaQuery, criteriaBuilder) ->
        {
            Predicate pred = criteriaBuilder.equal(root.get("first_name"),username);
            return criteriaBuilder.and(pred);
        });
        if(userOpt.isPresent()) {
           String hash1  = userOpt.get().getHash();
            try {
                String salt = Utilities.generateSalt();
                String hash = Utilities.computeHash(password, salt);
                if (hash.equals(hash1)) {
                    return null;
                }

            } catch (Exception e) {

            }
        }
return  null;
    }
}
