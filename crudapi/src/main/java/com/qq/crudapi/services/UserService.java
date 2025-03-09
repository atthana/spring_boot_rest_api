package com.qq.crudapi.services;

import java.util.List;
import java.util.Map;

import com.qq.crudapi.entity.User;

public interface UserService {
    User save(User user);
    List<User> findAll();
    User findById(int id);
    User updateUser(User user);
    User partialUpdateUser(int id, Map<String, Object> fields);
    void deleteUser(int id);
}
