package com.example.study.shiro.user.controller;

import com.example.study.shiro.user.entity.User;
import com.example.study.shiro.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author wangchenguang
 * @version 1.0
 * @date 2019/6/13
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(User user) {
        userService.login(user);
        return null;
    }


    public Map<String, Object> register() {
        return null;
    }

}
