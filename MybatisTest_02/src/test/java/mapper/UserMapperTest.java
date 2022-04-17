package mapper;

import com.foxmo.mapper.UserMapper;
import com.foxmo.pojo.User;
import com.foxmo.utils.MybatisUtils;
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

}
