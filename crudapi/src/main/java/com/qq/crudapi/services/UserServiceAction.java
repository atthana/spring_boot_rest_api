package com.qq.crudapi.services;

import com.qq.crudapi.entity.User;
import com.qq.crudapi.reposity.UserRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        // return userRepository.findById(id).orElse(null);
        
        User data = null;
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            data = user.get();
        } else {
            throw new RuntimeException("ไม่พบข้อมูลผู้ใช้รหัส: " + id);
        }
        return data;
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
    
    @Override
    public User partialUpdateUser(int id, Map<String, Object> fields) {
        // ค้นหา User ที่ต้องการอัปเดต
        User existingUser = findById(id);
        
        // อัปเดตเฉพาะฟิลด์ที่ส่งมา
        fields.forEach((key, value) -> {
            switch (key) {
                case "firstname":
                    existingUser.setFirstname((String) value);
                    break;
                case "lastname":
                    existingUser.setLastname((String) value);
                    break;
                // สามารถเพิ่มฟิลด์อื่นๆ ได้ในอนาคต
            }
        });
        
        // บันทึกการเปลี่ยนแปลง
        return userRepository.save(existingUser);
    }
}
 