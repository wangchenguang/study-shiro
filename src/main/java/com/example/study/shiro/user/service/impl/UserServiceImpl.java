package com.example.study.shiro.user.service.impl;

import com.example.study.shiro.user.entity.User;
import com.example.study.shiro.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

/**
 * @author wangchenguang
 * @version 1.0
 * @date 2019/6/13
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public void login(User user) {
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        // 传到MyAuthorizingRealm类中的方法进行认证
        currentUser.login(token);
        Session session = currentUser.getSession();
        session.setAttribute("user", user);
    }
}
