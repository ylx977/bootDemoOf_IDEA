package com.fuzamei.bean;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * Created by fuzamei on 2018/4/3.
 */
@Component
public class MyBean2 implements CommandLineRunner,Ordered {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("启动啦2.。。。");
    }

    @Override
    public int getOrder() {
        return 3;
    }
}
