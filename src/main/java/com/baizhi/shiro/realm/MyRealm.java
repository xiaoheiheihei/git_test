package com.baizhi.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;

public class MyRealm extends AuthenticatingRealm {
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获得用户身份信息
        AuthenticationInfo authenticationInfo = null;
        String principal = (String) authenticationToken.getPrincipal();
        if (principal.equals("zhangsan")) {
            //获得用户信息相当于从数据库中取值
            authenticationInfo = new SimpleAuthenticationInfo("zhangsan", "111111", this.getName());
        }
        return authenticationInfo;
    }
}
