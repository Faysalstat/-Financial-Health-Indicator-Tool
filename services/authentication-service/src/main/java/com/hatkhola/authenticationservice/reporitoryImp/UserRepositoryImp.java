package com.hatkhola.authenticationservice.reporitoryImp;

import com.hatkhola.authenticationservice.model.UserEntity;
import com.hatkhola.authenticationservice.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public class UserRepositoryImp implements UserRepository {
    @Override
    public UserEntity getUserByUserName(String userName) {
        return new UserEntity("admin","admin",new ArrayList());
    }
}
