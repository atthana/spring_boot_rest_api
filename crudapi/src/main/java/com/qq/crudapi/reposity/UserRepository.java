package com.qq.crudapi.reposity;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qq.crudapi.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
