package com.jwen.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jwen.login.domain.User;
import com.jwen.login.service.UserService;

@Controller
@EnableAutoConfiguration
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    @ResponseBody
    String welcome() {
        return "welcome my first spring boot project";
    }

    @RequestMapping("/notVerify")
    @ResponseBody
    String notVerify() {
        return "username or password NOT correct";
    }

    @RequestMapping("/login")
    String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping("/register")
    String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    @ResponseBody
    String registerUser(User user, Model model) {
        return userService.registerUser(user);
    }

    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    String userLogin(User user, Model model) {
        boolean verify = userService.verifyUser(user);
        if (verify) {
            model.addAttribute("name", user.getName());
            model.addAttribute("password", user.getPassword());
            return "result";
        } else {
            return "redirect:/notVerify";
        }

    }

}
