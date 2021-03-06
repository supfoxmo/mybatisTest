package com.foxmo.mapper;

import com.foxmo.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询单个用户信息
    User getUserById(int id);
    //分页查询
    List<User> getUserListByPage(Map<String,Integer> map);

}
