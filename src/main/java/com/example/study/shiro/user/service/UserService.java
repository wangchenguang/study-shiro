package com.example.study.shiro.user.service;

import com.example.study.shiro.user.entity.User;

/**
 * @author wangchenguang
 * @version 1.0
 * @date 2019/6/13
 */
public interface UserService {
    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return
     */
    User findByUsername(String username);

    void login(User user);
}
