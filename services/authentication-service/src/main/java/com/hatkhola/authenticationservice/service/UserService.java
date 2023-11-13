package com.hatkhola.authenticationservice.service;

import com.hatkhola.authenticationservice.model.UserEntity;

public interface UserService {
    UserEntity getUserByName(String userName);
}
