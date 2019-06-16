package com.example.study.shiro.user.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;
    @NotBlank
    @Column
    private String name;
    /**
     * 权限.
     */
    @OneToMany(cascade = CascadeType.MERGE)
    private List<Permission> permissions;

    @JSONField(serialize = false)
    @Column(name = "create_time")
    private Date createTime;

    @JSONField(serialize = false)
    @Column(name = "update_time")
    private Date updateTime;
}
