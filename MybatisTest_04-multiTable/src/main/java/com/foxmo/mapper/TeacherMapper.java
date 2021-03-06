package com.foxmo.mapper;

import com.foxmo.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
    @Select("select * from teacher")
    public List<Teacher> getAllTeacher();

    @Select("select * from teacher where id = #{id}")
    public Teacher getTeacherById(@Param("id") int id);
}
