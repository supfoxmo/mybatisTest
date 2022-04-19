package com.foxmo.mapper;

import com.foxmo.pojo.Teacher;
import com.foxmo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class StudentMapperTest {
    @Test
    public void test1(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            List<Teacher> teacherList = mapper.getAllTeacher();

            for (Teacher teacher : teacherList) {
                System.out.println(teacher);
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{

        }
    }
}
