package com.foxmo.mapper;

import com.foxmo.pojo.Blog;
import com.foxmo.utils.IDUtils;
import com.foxmo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;

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
            blog.setTitle("JavaSE如此简单");
            blog.setViews(1001);
            mapper.addBlog(blog);

            blog.setId(IDUtils.getID());
            blog.setCreateTime(new Date());
            blog.setTitle("Spring如此简单");
            blog.setViews(1001);
            mapper.addBlog(blog);

            blog.setId(IDUtils.getID());
            blog.setCreateTime(new Date());
            blog.setTitle("JavaWeb如此简单");
            blog.setViews(1001);
            mapper.addBlog(blog);

            blog.setId(IDUtils.getID());
            blog.setCreateTime(new Date());
            blog.setTitle("Maven如此简单");
            blog.setViews(1001);
            mapper.addBlog(blog);

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
    }
}
