package com.fuzamei.controller;

import com.fuzamei.pojo.JsonBean;
import com.fuzamei.utils.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by fuzamei on 2018/9/3.
 */
@RestController
@RequestMapping("/iptest")
public class IpController {

    private final HttpServletRequest request;

    @Autowired
    public IpController(HttpServletRequest request) {
        this.request = request;
    }

    @RequestMapping("/ip")
    public JsonBean testIp(){
        String ipAddress = IpUtil.getIpAddress(request);
        System.out.println(ipAddress);
        JsonBean jsonBean = new JsonBean();
        jsonBean.setName(ipAddress);
        return jsonBean;
    }

}
