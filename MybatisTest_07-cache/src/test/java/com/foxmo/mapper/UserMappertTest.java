package com.foxmo.mapper;

import com.foxmo.pojo.User;
import com.foxmo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;

public class UserMappertTest {
    @Test
    public void test1(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user1 = mapper.getUserById(1001);
            System.out.println(user1);
            System.out.println("==============================");
            //Mybatis默认打开一级缓存，且不能被关闭，一级缓存只在同一个SqlSession对象中有效，
            // 执行Add，Update和Delete操作后，自动删除缓存，也可以通过SqlSession.clearCache()手动清空缓存
            User user2 = mapper.getUserById(1001);

            System.out.println(user2);
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
            User user1 = mapper.getUserById(1001);
            System.out.println(user1);
            System.out.println("==============================");
            //手动清空缓存（方式一）
//            sqlSession.clearCache();

            //清空缓存（方式二：update）
//            HashMap<String, Object> map = new HashMap<>();
//            map.put("id","1001");
//            map.put("password","1234567");
//            mapper.updateUserById(map);

            //清空缓存（方式三：Delete）
//            mapper.deleteUserById(1001);

            //清空缓存（方式四：Add）
            User user = new User(1010, "周伊妮", "123456");
            mapper.addUser(user);

            //提交事务
            sqlSession.commit();

            User user2 = mapper.getUserById(1001);

            System.out.println(user2);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
    }
}
