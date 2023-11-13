package com.hatkhola.authenticationservice.repository;

import com.hatkhola.authenticationservice.model.UserEntity;

public interface UserRepository {
    UserEntity getUserByUserName(String userName);
}
