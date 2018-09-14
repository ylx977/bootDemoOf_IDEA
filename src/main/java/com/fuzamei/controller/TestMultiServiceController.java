package com.fuzamei.controller;

import com.fuzamei.pojo.JsonBean;
import com.fuzamei.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by fuzamei on 2018/8/30.
 */
@RestController
@RequestMapping("/testMultiService")
public class TestMultiServiceController {

    private final List<TestService> listService;

    private final Map<String,TestService> serviceMap;

    @Autowired
    public TestMultiServiceController(List<TestService> listService,
                                      Map<String, TestService> serviceMap) {
        this.listService = listService;
        this.serviceMap = serviceMap;
    }

    @RequestMapping("/list")
    public JsonBean testList(){
        listService.forEach(x->x.updateJsonBean());
        return new JsonBean();
    }

    @RequestMapping("/map")
    public JsonBean testMap(){
        serviceMap.forEach((x,y)-> System.out.println("key:"+x+"----->"+y));
        return new JsonBean();
    }


}
