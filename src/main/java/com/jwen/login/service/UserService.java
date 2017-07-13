package com.jwen.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwen.login.dao.UserRepository;
import com.jwen.login.domain.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean verifyUser(User user) {

        if ("jwen".equals(user.getName()) && "1234".equals(user.getPassword())) {
            return true;
        } else {
            return false;
        }

    }

    public String registerUser(User user) {

        if (userRepository.findByName(user.getName()).isEmpty()) {
            userRepository.save(user);
            return "用户名  " + user.getName() + " 注册成功";

        } else {

            return "用户名 " + user.getName() + "已被占用！";
        }

    }
}
