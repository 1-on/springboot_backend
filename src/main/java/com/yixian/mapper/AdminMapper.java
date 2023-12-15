package com.yixian.mapper;

import com.yixian.entity.Account;
import com.yixian.entity.Admin;

/**
* @author jiangfei
* @description 针对表【admin】的数据库操作Mapper
* @createDate 2023-12-14 20:08:02
* @Entity com.yixian.entity.Admin
*/
public interface AdminMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    Account selectByUserName(String username);
}
