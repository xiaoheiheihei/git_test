package com.baizhi.test;


import com.baizhi.service.ArticleService;
import com.baizhi.service.BannerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

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
}
