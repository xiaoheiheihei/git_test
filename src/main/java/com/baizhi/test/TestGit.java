package com.baizhi.test;


import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
import com.baizhi.service.BannerService;
import com.baizhi.shiro.realm.MyRealm;
import com.baizhi.shiro.realm.MyRealm1;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.Permission;
import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestGit {

    @Autowired
    ArticleService articleService;
    @Autowired
    BannerService bannerService;

    public static void main(String[] args) {
        System.out.println("这是一个测试类");
        System.out.println("是的");
        System.out.println("不是的");
        System.out.println(11111);
        System.out.println(22222);
    }

    @Test
    public void test1() {
        Map<String, Object> map = articleService.queryAll(2, 5);
    }

    @Test
    public void test3() {
        Map<String, Object> map = bannerService.queryAll(1, 5);
    }

    @Test
    public void test2() {
        String[] id = {"a"};
        articleService.delete(id);
    }

    @Test
    public void test4() {
        String[] ids = {"a", "d", "g", "r", "t", "e", "e", "s", "b"};
        List<String> list = new ArrayList<>(Arrays.asList(ids));
        /*list.forEach(a -> System.out.println(a));*/
        list.sort((e1, e2) -> {
            return e1.compareTo(e2);
        });
        list.forEach(a -> System.out.println(a));
        String[] ss = list.toArray(new String[list.size()]);
        for (String s : ss) {
            System.out.println("==========" + s);
        }
    }

    @Test
    public void test5() {
        Map<Article, HashMap<String, Object>> map = new HashMap<>();
        Article article = new Article(UUID.randomUUID().toString().replace("-", ""), "3", "3", "4", "6", new Date(), new Date(), "4");
        Article article1 = new Article(UUID.randomUUID().toString().replace("-", ""), "3", "3", "4", "6", new Date(), new Date(), "4");
        Article article2 = new Article(UUID.randomUUID().toString().replace("-", ""), "3", "3", "4", "6", new Date(), new Date(), "4");
        Article article3 = new Article(UUID.randomUUID().toString().replace("-", ""), "3", "3", "4", "6", new Date(), new Date(), "4");
        Article article4 = new Article(UUID.randomUUID().toString().replace("-", ""), "3", "3", "4", "6", new Date(), new Date(), "4");
        Article article5 = new Article(UUID.randomUUID().toString().replace("-", ""), "3", "3", "4", "6", new Date(), new Date(), "4");
        Article article6 = new Article(UUID.randomUUID().toString().replace("-", ""), "3", "3", "4", "6", new Date(), new Date(), "4");
        Article article7 = new Article(UUID.randomUUID().toString().replace("-", ""), "3", "3", "4", "6", new Date(), new Date(), "4");
        HashMap<String, Object> hashMap = new HashMap();
        HashMap<String, Object> hashMap1 = new HashMap();
        HashMap<String, Object> hashMap2 = new HashMap();
        HashMap<String, Object> hashMap3 = new HashMap();
        HashMap<String, Object> hashMap4 = new HashMap();
        HashMap<String, Object> hashMap5 = new HashMap();
        HashMap<String, Object> hashMap6 = new HashMap();
        HashMap<String, Object> hashMap7 = new HashMap();
        hashMap.put(UUID.randomUUID().toString().replace("-", ""), article);
        hashMap1.put(UUID.randomUUID().toString().replace("-", ""), article);
        hashMap2.put(UUID.randomUUID().toString().replace("-", ""), article);
        hashMap3.put(UUID.randomUUID().toString().replace("-", ""), article);
        hashMap4.put(UUID.randomUUID().toString().replace("-", ""), article);
        hashMap5.put(UUID.randomUUID().toString().replace("-", ""), article);
        hashMap6.put(UUID.randomUUID().toString().replace("-", ""), article);
        hashMap7.put(UUID.randomUUID().toString().replace("-", ""), article);

        map.put(article, hashMap);
        map.put(article1, hashMap1);
        map.put(article2, hashMap2);
        map.put(article3, hashMap3);
        map.put(article4, hashMap4);
        map.put(article5, hashMap5);
        map.put(article6, hashMap6);
        map.put(article7, hashMap7);
        Collection<HashMap<String, Object>> c = map.values();
        Iterator<HashMap<String, Object>> iterator = c.iterator();
        while (iterator.hasNext()) {
            HashMap<String, Object> next = iterator.next();
            Set<String> strings = next.keySet();
            strings.forEach(a -> {
                System.out.println("next的键为====" + a);
                System.out.println("next的值为====" + next.get(a));
            });
        }
        System.out.println("888888888888888888888888888888888888888");
        Set<Map.Entry<Article, HashMap<String, Object>>> entries = map.entrySet();
        Iterator<Map.Entry<Article, HashMap<String, Object>>> iterator1 = entries.iterator();
       /* while(iterator1.hasNext()){
            Map.Entry<Article, HashMap<String, Object>> next = iterator1.next();
            System.out.println("map的键为===="+next.getKey());
            System.out.println("map的值为===="+next.getValue());
            HashMap<String, Object> hmap = next.getValue();
            Set<Map.Entry<String, Object>> entries1 = hmap.entrySet();
            Iterator<Map.Entry<String, Object>> iterator2 = entries1.iterator();
            while(iterator2.hasNext()){
                Map.Entry<String, Object> next1 = iterator2.next();
                System.out.println("next1的键为===="+next1.getKey());
                System.out.println("next1的值为===="+next1.getValue());
            }*/
        List<Map.Entry<Article, HashMap<String, Object>>> list = new ArrayList<>();

        Collections.sort(list, new Comparator<Map.Entry<Article, HashMap<String, Object>>>() {
            @Override
            public int compare(Map.Entry<Article, HashMap<String, Object>> o1, Map.Entry<Article, HashMap<String, Object>> o2) {
                return (o1.getKey().hashCode()) - (o2.getKey().hashCode());
            }
        });
        while (iterator1.hasNext()) {
            Map.Entry<Article, HashMap<String, Object>> next = iterator1.next();
            System.out.println("map的键为====" + next.getKey());
            System.out.println("map的值为====" + next.getValue());
            HashMap<String, Object> hmap = next.getValue();
            Set<Map.Entry<String, Object>> entries1 = hmap.entrySet();
            Iterator<Map.Entry<String, Object>> iterator2 = entries1.iterator();
            while (iterator2.hasNext()) {
                Map.Entry<String, Object> next1 = iterator2.next();
                System.out.println("next1的键为====" + next1.getKey());
                System.out.println("next1的值为====" + next1.getValue());
            }
        }

    }

    @Test
    public void test6() {
        //获得securityManager（安全管理器）
        Realm realm = new IniRealm("classpath:shiro.ini");
        SecurityManager securityManager = new DefaultSecurityManager(realm);
        //把securityManager交给SecurityUtils管理
        SecurityUtils.setSecurityManager(securityManager);
        //获得主体
        Subject subject = SecurityUtils.getSubject();
        //获得主体中的登录认证
        AuthenticationToken token = new UsernamePasswordToken("lisi", "000000");
        //UnknownAccountException:用户名输入错误
        //IncorrectCredentialsException:密码输入错误
        try {
            subject.login(token);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            boolean authenticated = subject.isAuthenticated();
            System.out.println(authenticated);
        }
    }


    @Test
    public void test7() {
        //获得securityManager(安全管理器)
        Realm realm = new MyRealm();
        SecurityManager securityManager = new DefaultSecurityManager(realm);
        //把securityManager交给SecurityUtils的管理（把securityManager值set到SecurityUtils中）
        SecurityUtils.setSecurityManager(securityManager);
        //获得主体
        Subject subject = SecurityUtils.getSubject();
        //登录验证认证信息
        AuthenticationToken token = new UsernamePasswordToken("zhangsan", "111111");
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        } finally {
            boolean authenticated = subject.isAuthenticated();
            System.out.println(authenticated);
        }

    }

    @Test
    public void test8() {
        Realm realm = new MyRealm1();
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("Md5");
        credentialsMatcher.setHashIterations(1024);
        ((MyRealm1) realm).setCredentialsMatcher(credentialsMatcher);
        SecurityManager securityManager = new DefaultSecurityManager(realm);
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();

        /*//原始密码 盐 散列次数
        Md5Hash md5Hash=new Md5Hash("000000","ads",1024);
        String s=md5Hash.toHex();//十六进制*/
        AuthenticationToken token = new UsernamePasswordToken("zhangsan", "000000");
        try {
            subject.login(token);

        } catch (AuthenticationException e) {
            e.printStackTrace();
        } finally {
            boolean authenticated = subject.isAuthenticated();
            if (authenticated) {
                List<String> list = new ArrayList<>();
                boolean aSuper = subject.hasRole("supper");
                list.add("supper");
                list.add("admin");
                list.add("user");
                boolean[] booleans = subject.hasRoles(list);
                for (boolean aBoolean : booleans) {
                    System.out.println(aBoolean);
                }
                boolean b = subject.hasAllRoles(list);
                boolean permitted = subject.isPermitted("user:delete:007");
                System.out.println(permitted);
                List<Permission> list1 = new ArrayList<>();
                boolean permittedAll = subject.isPermittedAll("user:delete", "user:add");
                System.out.println(permittedAll);
                boolean[] permitted1 = subject.isPermitted("user:delete", "user:add");
                for (boolean b1 : permitted1) {
                    System.out.println(b1);
                }
            }
        }
    }

    @Test
    public void name() {
        Md5Hash md5Hash = new Md5Hash("000000", "ads", 1024);
        String s = md5Hash.toHex();//十六进制*
        System.out.println(s);
    }
}
