package com.hatkhola.authenticationservice.serviceImp;

import com.hatkhola.authenticationservice.model.UserEntity;
import com.hatkhola.authenticationservice.reporitoryImp.UserRepositoryImp;
import com.hatkhola.authenticationservice.repository.UserRepository;
import com.hatkhola.authenticationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserEntity getUserByName(String userName) {
        return userRepository.getUserByUserName(userName);
    }
}
