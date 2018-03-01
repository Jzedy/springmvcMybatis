package com.cn.jzedy.shiro;

import com.cn.jzedy.common.model.User;
import com.cn.jzedy.common.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import javax.annotation.Resource;

/**
 * Created by Jzedy on 2018/3/1
 */
public class UserRealm extends AuthorizingRealm {

    @Resource(name = "userService")
    private UserService userService;

    /**
     * 提供用户信息返回权限信息
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // TODO: 2018/3/1  待写
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        return info;
    }

    /**
     * 提供账户返回认证信息
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String loginName = (String) token.getPrincipal();
        User user = userService.getUserByUsername(loginName);
        if (user == null){
            return null;
        }else {
            return new SimpleAuthenticationInfo(token.getPrincipal(),user.getPassword(),user.getUsername());
        }
    }
}
