package com.fuzamei.controller;

import com.fuzamei.pojo.JsonBean;
import com.fuzamei.pojo.ValidBean;
import com.fuzamei.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by fuzamei on 2018/8/30.
 */
@RestController
@RequestMapping("/valid")
public class TestValidController {

    @RequestMapping("/valid")
    public JsonBean testValid(@RequestBody @Valid ValidBean validBean){

        System.out.println(validBean.getAge());
        System.out.println(validBean.getName());

        JsonBean jsonBean = new JsonBean();
        jsonBean.setName("success");
        return jsonBean;
    }

    @RequestMapping("/valid2")
    public JsonBean testValid2(@RequestBody @Validated ValidBean validBean){

        System.out.println(validBean.getAge());
        System.out.println(validBean.getName());

        JsonBean jsonBean = new JsonBean();
        jsonBean.setName("success");
        return jsonBean;
    }


}
