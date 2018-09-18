package com.fuzamei.controller;

import com.fuzamei.pojo.JsonBean;
import com.fuzamei.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fuzamei on 2018/9/17.
 */
@RestController
@RequestMapping("/cookie")
public class CookieController {

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/setCookie")
    public JsonBean setCookie(){
        JsonBean jsonBean = new JsonBean();
        jsonBean.setName("success");
        Map<String,String> data = new HashMap<>();
        data.put("name","ylx");
        data.put("age","19");
        data.put("sex","male");
        data.put("address","hangzhou");
        jsonBean.setData(data);
        return jsonBean;
    }

    @RequestMapping("/getCookie")
    public JsonBean getCookie(){
        JsonBean jsonBean = new JsonBean();
        String name = CookieUtil.getCookie(request, "name");
        String age = CookieUtil.getCookie(request, "age");
        String address = CookieUtil.getCookie(request, "address");
        String sex = CookieUtil.getCookie(request, "sex");
        System.out.println("name:"+name);
        System.out.println("age:"+age);
        System.out.println("address:"+address);
        System.out.println("sex:"+sex);
        jsonBean.setName("name:"+name+"---age:"+age+"---address:"+address+"---sex:"+sex);
        return jsonBean;
    }

}
