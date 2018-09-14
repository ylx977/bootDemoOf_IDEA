package com.fuzamei.controller;

import com.fuzamei.pojo.JsonBean;
import com.fuzamei.pojo.Staff;
import com.fuzamei.service.incursive.IncursiveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@RestController
@Slf4j
@RequestMapping("/incursive")
public class IncursiveController {

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private IncursiveService incursiveService;

    @RequestMapping("/findSubordinates")
    public Staff findSubordinates(){
        Staff staff = incursiveService.findSubordinates();
        return staff;
    }

}
