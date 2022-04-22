package com.foxmo.mapper;

import com.foxmo.pojo.Blog;
import com.foxmo.utils.IDUtils;
import com.foxmo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class BlogMapperTest {
    @Test
    public void test1(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            Blog blog = new Blog(IDUtils.getID(), "Mybatis如此简单", "foxmo", new Date(), 999);
            mapper.addBlog(blog);

            blog.setId(IDUtils.getID());
            blog.setCreateTime(new Date());
            blog.setTitle("Mysql如此简单");
            blog.setViews(1001);
            mapper.addBlog(blog);

            blog.setId(IDUtils.getID());
            blog.setCreateTime(new Date());
            blog.setAuthor("joker");
            blog.setTitle("JavaSE如此简单");
            blog.setViews(235);
            mapper.addBlog(blog);

            blog.setId(IDUtils.getID());
            blog.setCreateTime(new Date());
            blog.setTitle("Spring如此简单");
            blog.setViews(172);
            mapper.addBlog(blog);

            blog.setId(IDUtils.getID());
            blog.setCreateTime(new Date());
            blog.setTitle("JavaWeb如此简单");
            blog.setViews(2033);
            mapper.addBlog(blog);

            blog.setId(IDUtils.getID());
            blog.setCreateTime(new Date());
            blog.setTitle("Maven如此简单");
            blog.setViews(129);
            mapper.addBlog(blog);

//            sqlSession.commit();

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
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            HashMap<String, Object> map = new HashMap<>();
//            map.put("title","Mysql如此简单");
            map.put("author","joker");

            List<Blog> blogList = mapper.getBlogIF(map);
            for (Blog blog : blogList) {
                System.out.println(blog);
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
    }

    @Test
    public void test3(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            HashMap<String, Object> map = new HashMap<>();
//            map.put("title","Mysql如此简单");
//            map.put("author","foxmo");
            map.put("views",300);

            List<Blog> blogList = mapper.getBlogChoose(map);
            for (Blog blog : blogList) {
                System.out.println(blog);
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
    }

    @Test
    public void test4(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            HashMap<String, Object> map = new HashMap<>();

            map.put("id","5393a7272ab04bedaf304827683db54f");
            map.put("title","Linux如此简单");
            map.put("author","foxmo");
            map.put("views","999");


            mapper.updateBlogSet(map);

            sqlSession.commit();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
    }


    @Test
    public void test5(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            HashMap<String, Object> map = new HashMap<>();

            ArrayList<String> ids = new ArrayList<>();
            ids.add("2275908bc8844e368fc9fb23fa29b5a9");
            ids.add("5393a7272ab04bedaf304827683db54f");
            ids.add("3dbf0fb98735436fbc15611ccfa176ce");
            ids.add("d5915bb776d849cfb2b991b21fc4348e");

            map.put("ids",ids);
            mapper.getBlogForeach(map);

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
    }
}
