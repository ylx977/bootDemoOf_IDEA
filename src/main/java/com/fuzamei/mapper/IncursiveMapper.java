package com.fuzamei.mapper;

import com.fuzamei.pojo.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IncursiveMapper {

    @Select("select * from subordinate where pid = #{pid}")
    List<Staff> findStaffsByPid(@Param("pid") Long pid);

    @Select("select * from subordinate where id = #{id}")
    Staff findStaffById(@Param("id") Long id);
}
