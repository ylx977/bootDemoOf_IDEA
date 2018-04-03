package com.fuzamei.bean;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * Created by fuzamei on 2018/4/3.
 */
@Component
public class MyBean implements CommandLineRunner,Ordered {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("启动啦。。。。。");
    }

    @Override
    public int getOrder() {
        return 2;//决定了执行顺序，1最靠前，2其次，以此类推，前提是实现了ordered接口
    }
}
