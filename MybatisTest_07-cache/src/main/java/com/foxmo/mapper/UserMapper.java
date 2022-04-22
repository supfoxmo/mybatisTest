package com.foxmo.mapper;

import com.foxmo.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User getUserById(@Param("id") int id);
}
