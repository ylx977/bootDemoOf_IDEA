package com.fuzamei.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Staff {

    private Long id;
    private String name;
    private Integer age;
    private Long pid;
    private Long ctime;
    private Long utime;
    private List<Staff> subordinates;

}
