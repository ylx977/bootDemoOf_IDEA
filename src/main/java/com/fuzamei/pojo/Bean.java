package com.fuzamei.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Created by fuzamei on 2018/3/11.
 */
@Setter
@Getter
@ToString
public class Bean {
    private Integer id;
    private Integer age;
    private String name;
    private Date createTime;

    public Bean(Integer id, Integer age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Bean() {
    }

    public static void main(String[] args) {
        Bean bean = new Bean();
        bean.setAge(10);
        bean.setId(2);
        bean.setName("haha");
        System.out.println(bean);


    }
}
