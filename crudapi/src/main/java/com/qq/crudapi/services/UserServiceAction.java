package com.qq.crudapi.services;

import com.qq.crudapi.entity.User;
import com.qq.crudapi.reposity.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceAction implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceAction(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);  // user ก็คือ entity ที่จะส่งเข้าไปทำงาน
    }
}
 