package com.example.study.shiro.user;

import com.example.study.shiro.user.entity.Permission;
import com.example.study.shiro.user.entity.Role;
import com.example.study.shiro.user.entity.User;
import com.example.study.shiro.user.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wangchenguang
 * @version 1.0
 * @date 2019/6/13
 */
public class UserRealm extends AuthorizingRealm {
    private static final Logger logger = LoggerFactory.getLogger(UserRealm.class);

    @Autowired
    private UserService userService;

    /**
     * 权限信息，包括角色以及权限.
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //如果身份认证的时候没有传入User对象，这里只能取到userName
        //也就是SimpleAuthenticationInfo构造的时候第一个参数传递需要User对象
        User user = (User) principals.getPrimaryPrincipal();

        for (Role role : user.getRoles()) {
            authorizationInfo.addRole(role.getName());
            for (Permission p : role.getPermissions()) {
                authorizationInfo.addStringPermission(p.getName());
            }
        }
        return authorizationInfo;
    }

    /**
     * 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。
     *
     * @param token 验证对象
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
        //获取用户的输入的账号.
        String userName = (String) token.getPrincipal();
        System.out.println(token.getCredentials());
        //通过username从数据库中查找 User对象.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        User user = userService.findByUsername(userName);
        if (user == null) {
            return null;
        }
        return new SimpleAuthenticationInfo(
                //这里传入的是user对象，比对的是用户名，直接传入用户名也没错，但是在授权部分就需要自己重新从数据库里取权限
                user,
                //密码
                user.getPassword(),
                //salt=username+salt
                ByteSource.Util.bytes(user.getSalt()),
                //realm name
                getName()
        );
    }

}
