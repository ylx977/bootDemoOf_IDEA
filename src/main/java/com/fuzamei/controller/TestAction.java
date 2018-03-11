package com.fuzamei.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Created by fuzamei on 2018/3/11.
 */
@RestController
public class TestAction {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello() {
        HashMap<Object, Object> hashmap = new HashMap<>();

        return "hello world1";

    }
}
