package com.qq.crudapi.crudapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @GetMapping("/users")
    public String getAllUsers() {
        return "Q-Electronics555";
    }

    @GetMapping("/about")
    public String getAbout() {
        return "เกี่ยวกับเรา";
    }

    @GetMapping("/address")
    public String getAddress() {
        return "บ้านนีโอ";
    }

    @GetMapping("/job")
    public String getJob() {
        return "วิศวกรซอฟต์แวร์";
    }
}