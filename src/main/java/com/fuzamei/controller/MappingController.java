package com.fuzamei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * Created by fuzamei on 2018/4/16.
 */
@RestController
public class MappingController extends BaseController{

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @RequestMapping("/mapping")
    private String getUrl(){
        throw new RuntimeException("我报错了一个异常信息");
    }
}
