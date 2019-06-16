package com.example.study.shiro.user.repository;

import com.example.study.shiro.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户信息查询接口
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
