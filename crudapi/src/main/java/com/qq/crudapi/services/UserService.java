package com.qq.crudapi.services;

import java.util.List;

import com.qq.crudapi.entity.User;

public interface UserService {
    User save(User user);
    List<User> findAll();
}
