package com.example.study.shiro.user.entity;

import lombok.Data;

import java.util.List;

/**
 * @author wangchenguang
 * @version 1.0
 * @date 2019/6/13
 */
@Data
public class Role {
    private String name;
    private List<Permission> permissions;
}
