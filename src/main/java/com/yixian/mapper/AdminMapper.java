package com.yixian.mapper;

import com.yixian.entity.Admin;
import org.apache.ibatis.annotations.Select;

public interface AdminMapper {

    @Select("select * from admin where username = #{username}")
    Admin selectByUserName(String username);
}
