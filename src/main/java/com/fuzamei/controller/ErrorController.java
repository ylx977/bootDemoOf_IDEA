package com.fuzamei.controller;

import com.fuzamei.pojo.JsonBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fuzamei on 2018/9/14.
 */
@RestController
public class ErrorController {

    @RequestMapping("/errors")
    public JsonBean error(){
        JsonBean jsonBean = new JsonBean();
        jsonBean.setName("success");
        return jsonBean;
    }

}
