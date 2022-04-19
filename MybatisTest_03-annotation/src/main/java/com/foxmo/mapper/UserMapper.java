package com.foxmo.mapper;

import com.foxmo.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询全部信息
    @Select("select * from user")
    List<User> getAllUserList();

    //查询指定用户的密码
    @Select("select password from user where id = #{id} and name = #{username}")
    String getPwdByIDAndName(@Param("id") int id,@Param("username") String name);

    //增加用户信息
    @Insert("insert into user(id,name,password) values(#{id},#{name},#{password})")
    int addUser(User user);

    //修改用户信息
    @Update("update user set name=#{name},password=#{password} where id =#{id}")
    int updateUser(User user);

    //删除用户信息
    @Delete("Delete from user where id = #{id}")
    int deleteUser(@Param("id") int id);

}
