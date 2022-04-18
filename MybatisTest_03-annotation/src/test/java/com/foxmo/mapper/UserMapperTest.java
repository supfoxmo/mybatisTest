package com.foxmo.mapper;

import com.foxmo.Utils.MybatisUtils;
import com.foxmo.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.List;

public class UserMapperTest {
    @Test
    public void test1(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getAllUserList();
            for (User user : userList) {
                System.out.println(user);
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
    }

    @Test
    public void test2(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            String password = mapper.getPwdByIDAndName(1004,"李晓明");
            System.out.println("李晓明(1004): " + password);

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
    }
}
