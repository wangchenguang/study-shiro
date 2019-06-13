package com.example.study.shiro.user.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author wangchenguang
 * @version 1.0
 * @date 2019/6/13
 */
@Getter
@Setter
public class User {
    private String username;
    private String password;
    private String salt;
    private List<Role> roles;
}
