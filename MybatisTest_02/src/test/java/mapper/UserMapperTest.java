package mapper;

import com.foxmo.mapper.UserMapper;
import com.foxmo.pojo.User;
import com.foxmo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void test1(){

        SqlSession sqlSession = null;

        try {
            //第一步：获取SqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
            //日志测试
            logger.info(sqlSession);
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
    public void test2(){

        SqlSession sqlSession = null;

        try {
            //第一步：获取SqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
            //日志测试
            logger.info(sqlSession);
            //方式一：getMapper
            UserMapper usermapper = sqlSession.getMapper(UserMapper.class);

            HashMap<String, Integer> map = new HashMap<>();
            map.put("startIndex",0);
            map.put("pageSize",2);
            //调用接口方法，执行sql语句
            List<User> userList = usermapper.getUserListByPage(map);
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

}
