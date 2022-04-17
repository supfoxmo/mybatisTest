package com.foxmo.mapper;

import com.foxmo.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询全部数据
    List<User> getUserList();
    //查询单个用户信息
    User getUserById(int id);
    //插入数据
    void addUser(User user);
    //修改数据
    void updateUser(User user);
    //删除数据
    void deleteUser(int id);
    //模糊查询
    List<User> getLikeUserList(Map<String,Object> map);
}
