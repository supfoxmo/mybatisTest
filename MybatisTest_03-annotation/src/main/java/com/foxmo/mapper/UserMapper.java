package com.foxmo.mapper;

import com.foxmo.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询全部信息
    @Select("select * from user")
    List<User> getAllUserList();

    //查询指定用户的密码
    @Select("select password from user where id = #{id} and name = #{username}")
    String getPwdByIDAndName(@Param("id") int id,@Param("username") String name);
}
