package com.foxmo.mapper;

import com.foxmo.pojo.User;
import com.sun.xml.internal.ws.developer.Serialization;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Serialization
public interface UserMapper {
    //通过id指定查询用户信息
    User getUserById(@Param("id") int id);
    //通过id指定删除用户信息
    int deleteUserById(@Param("id") int id);
    //通过id指定修改用户信息
    int updateUserById(Map map);
    //新增用户信息
    int addUser(User user);
}
