package com.fuzamei.service.impl;

import com.fuzamei.pojo.JsonBean;
import com.fuzamei.service.TestService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author ylx
 * Created by fuzamei on 2018/8/30.
 */
@Service(value = "B")
public class TestServiceImplB implements TestService {
    @Override
    public JsonBean getJsonBean() {
        JsonBean jsonBean = new JsonBean();
        jsonBean.setName("yanglingxiao");
        jsonBean.setCreateTime(new Date());
        jsonBean.setAge(12);
        return jsonBean;
    }

    @Override
    public void updateJsonBean() {
        System.out.println("updateB");
    }

    @Override
    public void deleteJsonBean() {
        System.out.println("deleteB");
    }
}
