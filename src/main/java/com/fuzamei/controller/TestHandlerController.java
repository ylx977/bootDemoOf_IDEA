package com.fuzamei.controller;

import com.fuzamei.pojo.JsonBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author ylx
 * Created by fuzamei on 2018/8/28.
 */
@RestController
@RequestMapping("/handler")
public class TestHandlerController {

    @RequestMapping("/hhh")
    public JsonBean testHandler(){
        JsonBean jsonBean = new JsonBean();
        jsonBean.setCreateTime(new Date());
        jsonBean.setName("杨凌霄");
        return jsonBean;
    }

}
