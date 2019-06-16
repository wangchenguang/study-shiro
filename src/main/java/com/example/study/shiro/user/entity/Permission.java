package com.example.study.shiro.user.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author wangchenguang
 * @version 1.0
 * @date 2019/6/13
 */
@Data
@Entity
public class Permission implements Serializable {
    @Id
    private Long id;

    private String name;
}
