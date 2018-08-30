package com.fuzamei.controller;

import com.fuzamei.pojo.JsonBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author ylx
 * Created by fuzamei on 2018/8/26.
 */
@RestController
@RequestMapping("/testJson")
public class TestFastJsonController {

    @RequestMapping("/haha")
    public JsonBean testJson(){
        JsonBean jsonBean = new JsonBean();
        jsonBean.setAge(12);
        jsonBean.setCreateTime(new Date());
        jsonBean.setName("杨凌霄");
        return jsonBean;
    }

}
