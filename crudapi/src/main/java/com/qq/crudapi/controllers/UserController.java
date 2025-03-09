package com.qq.crudapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qq.crudapi.entity.User;
import com.qq.crudapi.services.UserService;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
        // ค้นหาผู้ใช้ตาม id และส่งกลับผลลัพธ์
        return userService.findById(id);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        // ลบผู้ใช้ตาม id
        userService.deleteUser(id);
    }
    
    @PatchMapping("/users/{id}")
    public User partialUpdateUser(@PathVariable int id, @RequestBody Map<String, Object> fields) {
        // ค้นหาผู้ใช้ตาม id และส่งกลับผลลัพธ์
        System.out.println("---- partialUpdateUser ----");
        System.out.println(id);
        System.out.println(fields);
        return userService.partialUpdateUser(id, fields);
    }
}