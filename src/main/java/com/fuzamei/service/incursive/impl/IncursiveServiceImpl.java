package com.fuzamei.service.incursive.impl;

import com.alibaba.fastjson.JSON;
import com.fuzamei.mapper.IncursiveMapper;
import com.fuzamei.pojo.Staff;
import com.fuzamei.service.incursive.IncursiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Collections;
import java.util.List;

@Service
public class IncursiveServiceImpl implements IncursiveService {

    @Autowired
    private IncursiveMapper incursiveMapper;

    @Autowired
    private JedisPool jedisPool;

    @Override
    public Staff findSubordinates() {
        Jedis jedis = jedisPool.getResource();
        try {
            String staffString = jedis.get("staff:" + 1);
            if(StringUtils.isEmpty(staffString)){
                Staff staff = incursiveMapper.findStaffById(1L);
                if(staff==null){
                    return null;
                }
                inject(staff);
                jedis.set("staff:1",JSON.toJSONString(staff));
                return staff;
            }
            return JSON.parseObject(staffString,Staff.class);
        }finally {
            jedis.close();
        }
    }


    private void inject(Staff staff){
        Long id = staff.getId();
        if(id==0){
            return;
        }
        List<Staff> staffsByPid = incursiveMapper.findStaffsByPid(id);
        for (Staff sub : staffsByPid){
            inject(sub);
        }
        staff.setSubordinates(staffsByPid);
    }

}
