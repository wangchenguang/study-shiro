package com.example.study.shiro.user.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author wangchenguang
 * @version 1.0
 * @date 2019/6/13
 */
@Data
@Table(name = "user")
@Entity
public class User implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    /**
     * 用户名
     */
    @NotBlank
    @Column(length = 64, columnDefinition = "varchar(64) not null")
    private String username;

    /**
     * 密码
     */
    @NotBlank
    @Column(length = 64, columnDefinition = "varchar(64) not null")
    private String password;

    /**
     * 盐
     */
    @JSONField(serialize = false)
    @Column(length = 32, columnDefinition = "varchar(32) not null")
    private String salt;

    /**
     * 用户角色
     */
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "id", referencedColumnName = "role_id")})
    private List<Role> roles;
    /**
     * 创建时间
     */
    @JSONField(serialize = false)
    @Column(name = "create_time", columnDefinition = "datetime not null")
    private Date createTime;

    /**
     * 修改时间
     */
    @JSONField(serialize = false)
    @Column(name = "update_time", columnDefinition = "datetime not null")
    private Date updateTime;

    /**
     * 登录时间
     */
    private Date loginTime;
}
