package com.fuzamei.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Created by fuzamei on 2018/3/11.
 */
@RestController
public class TestAction {

    @Value(value = "${book.name}")
    private String bookName;

    @Value(value = "${book.author}")
    private String bookAuthor;

    @Value(value = "${book.desc}")
    private String bookDesc;

    @Value(value = "${com.fuzamei.randomString}")
    private String randomString;

    @Value(value = "${com.fuzamei.randomNumber}")
    private int randomNumber;//也可以用String类型接收

    @Value(value = "${com.fuzamei.randomBigNum}")
    private long randomBigNum;//也可以用String类型接收

    @Value(value = "${com.fuzamei.randomTest1}")
    private int randomTest1;//也可以用String类型接收

    @Value(value = "${com.fuzamei.randomTest2}")
    private int randomTest2;//也可以用String类型接收

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello() {
        HashMap<Object, Object> hashmap = new HashMap<>();
        hashmap.put("haha","haha");
        return "hello world2弄好";

    }
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test() {
        HashMap<Object, Object> hashmap = new HashMap<>();
        hashmap.put("haha","haha");
        String str = bookName+"--"+bookAuthor+"---"+bookDesc;
        return str+"你好啊";

    }
    @RequestMapping(value = "/random",method = RequestMethod.GET)
    public String random() {
        String str = randomString+"--"+randomNumber+"---"+randomBigNum+"---"+randomTest1+"---"+randomTest2;
        return str;

    }

}
