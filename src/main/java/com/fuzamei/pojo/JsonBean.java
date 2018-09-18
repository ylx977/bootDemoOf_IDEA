package com.fuzamei.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author ylx
 * Created by fuzamei on 2018/8/26.
 */
@Data
public class JsonBean {

    private String name;
    private Integer age;
    @JSONField(format = "yyyy-mm-dd")
    private Date createTime;
    private String address;
    private List<?> list;
    private Object data;

}
