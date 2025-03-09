package com.qq.crudapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qq.crudapi.entity.User;
import com.qq.crudapi.services.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    // TODO: implement controller methods

    private UserService userService; // dependency

    @Autowired
    public UserController(UserService userService) { // สร้าง constructor
        this.userService = userService;
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {  // จะส่ง json เข้าไปทำงานกับ user นี้
        user.setId(0); // กำหนด id เป็น 0 เพื่อให้มันรู้ว่าต้อง save ใหม่เข้าไปในระบบ
        return userService.save(user);
    }
}