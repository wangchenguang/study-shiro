package com.example.study.shiro.user.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

/**
 * @author wangchenguang
 * @version 1.0
 * @date 2019/6/13
 */
@Entity
@Data
public class Role implements Serializable {
    @Id
    private Long id;
    @NotBlank
    private String name;
    private List<Permission> permissions;
}
