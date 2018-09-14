package com.fuzamei.controller;

import com.fuzamei.pojo.JsonBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        List<String> list = new ArrayList<>();
        list.add("list1");
        list.add("list2");
        list.add("list3");
        list.add("list4");
        jsonBean.setList(list);
        return jsonBean;
    }

}
