package com.foxmo.mapper;

import com.foxmo.pojo.Blog;
import org.apache.ibatis.annotations.Insert;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
//    @Insert("insert into blog(id,title,author,create_time,views)\n" +
//            "        values(#{id},#{title},#{author},#{createTime},#{views})")
    int addBlog(Blog blog);

    //根据传送的参数，实现不同的查询
    List<Blog> getBlogIF(Map<String,Object> map);

    //根据传送的参数，实现不同的查询
    List<Blog> getBlogChoose(Map<String,Object> map);

    //更新数据
    int updateBlogSet(Map<String,Object> map);

    //更具id集合，查询指定的Blog信息
    List<Blog> getBlogForeach(Map<String,Object> map);
}
