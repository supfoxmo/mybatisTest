package com.foxmo.mapper;

import com.foxmo.pojo.User;
import com.foxmo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserMappertTest {
    @Test
    public void test1(){
        SqlSession sqlSession1 = null;
        SqlSession sqlSession2 = null;
        try {
            //二级缓存：当一个对话SqlSession结束后，会将器一级缓存中的数据存放到二级缓存中，
            //等待下一次对话SqlSession查询数据时，先从二级缓存中查找数据,若查询不到，则查询一级缓存，
            // 若一级缓存任然查询不到，才会到数据库查询
            sqlSession1 = MybatisUtils.getSqlSession();
            UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
            User user1 = mapper1.getUserById(1010);
            System.out.println(user1);
            sqlSession1.close();

            System.out.println("=================================");

            sqlSession2 = MybatisUtils.getSqlSession();
            UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
            User user2 = mapper2.getUserById(1010);
            System.out.println(user2);
            sqlSession2.close();


        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if (sqlSession1 != null)
                sqlSession1.close();
            if (sqlSession2 != null)
                sqlSession2.close();
        }
    }

}
