package com.foxmo.mapper;

import com.foxmo.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
    public List<Teacher> getAllTeacher();

    //查询指定的老师及其学生的信息
    public Teacher getTeacherById(@Param("id") int id);
}
