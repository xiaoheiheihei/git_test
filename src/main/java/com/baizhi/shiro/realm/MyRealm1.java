package com.baizhi.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class MyRealm1 extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        AuthorizationInfo authorizationInfo = null;
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        if (primaryPrincipal.equals("zhangsan")) {
            authorizationInfo = new SimpleAuthorizationInfo();
            ((SimpleAuthorizationInfo) authorizationInfo).addRole("supper");
            ((SimpleAuthorizationInfo) authorizationInfo).addStringPermission("user:delete:*");
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        AuthenticationInfo authenticationInfo = null;
        String principal = (String) authenticationToken.getPrincipal();
        if (principal.equals("zhangsan")) {
            authenticationInfo = new SimpleAuthenticationInfo("zhangsan", "8fdda37668d4785fadb10543610668e7", ByteSource.Util.bytes("ads"), this.getName());
        }
        return authenticationInfo;
    }
}
