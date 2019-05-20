package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author: 我的袜子都是洞
 * @description:
 * @path: YellowStar-util-MybatisUtil
 * @date: 2019-05-20 18:55
 */
public class MybatisUtil {
    // MyBatis 配置文件
    private static String resource = "mybatis-config.xml";
    private static InputStream inputStream;
    private static SqlSessionFactory sqlSessionFactory;
    // session 非线程安全
    private static SqlSession session;

    static {
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static SqlSession getSession() throws Exception{
        session = sqlSessionFactory.openSession();
        return session;
    }
}
