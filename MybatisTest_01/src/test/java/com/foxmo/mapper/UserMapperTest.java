package com.foxmo.mapper;

import com.foxmo.utils.MybatisUtils;
import com.foxmo.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    @Test
    public void test1(){
        SqlSession sqlSession = null;

        try {
            //第一步：获取SqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
            //方式一：getMapper
            UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = usermapper.getUserList();

            for (User user : userList) {
                System.out.println(user);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void test2(){
        SqlSession sqlSession = null;

        try {
            //第一步：获取SqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
            //方式一：getMapper
            UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
            //调用接口方法，执行sql语句
            User user = usermapper.getUserById(1005);
            System.out.println(user);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void test3(){
        SqlSession sqlSession = null;

        try {
            //第一步：获取SqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
            //方式一：getMapper
            UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
            //调用接口方法，执行sql语句
            usermapper.addUser(new User(1007,"张三","123456"));
            //增删改操作需要提交事务
            sqlSession.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void test4(){
        SqlSession sqlSession = null;

        try {
            //第一步：获取SqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
            //方式一：getMapper
            UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
            //调用接口方法，执行sql语句
            usermapper.updateUser(new User(1006,"李四","123456"));
            //增删改操作需要提交事务
            sqlSession.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void test5(){
        SqlSession sqlSession = null;

        try {
            //第一步：获取SqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
            //方式一：getMapper
            UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
            //调用接口方法，执行sql语句
            usermapper.deleteUser(1006);
            //增删改操作需要提交事务
            sqlSession.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void test6(){
        SqlSession sqlSession = null;

        try {
            //第一步：获取SqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
            //方式一：getMapper
            UserMapper usermapper = sqlSession.getMapper(UserMapper.class);

            Map<String, Object> map = new HashMap<>();
            map.put("likeName","李_%");
            //调用接口方法，执行sql语句
            List<User> likeUserList = usermapper.getLikeUserList(map);

            for (User user : likeUserList) {
                System.out.println(user);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //关闭SqlSession
            sqlSession.close();
        }
    }
}
