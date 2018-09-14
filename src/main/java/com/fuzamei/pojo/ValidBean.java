package com.fuzamei.pojo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by fuzamei on 2018/9/1.
 */
@Data
public class ValidBean {

    @NotEmpty(message = "姓名不能为空串")
    @NotNull(message = "姓名不能为空")
    private String name;

    @NotNull(message = "年龄不能为空")
    private Integer age;
}
