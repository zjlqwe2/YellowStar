package dao;

import entity.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.MybatisUtil;
import java.sql.SQLException;
import java.util.List;
import static org.junit.Assert.*;

/**
 * @author: 我的袜子都是洞
 * @description:
 * @path: PropertyManagement-dao-TestUserDao
 */
public class TestUserDao {
    private SqlSession session;
    private UserMapper mapper;

    @Before
    public void before () throws Exception{
        session = MybatisUtil.getSession();
        mapper = session.getMapper(UserMapper.class);
    }

    @Test
    public void testAddUser() throws SQLException {
        User user = new User();
        user.setLoginName("yellow");
        user.setPassWord("admin");
        user.setUserType(2);
        boolean flag = mapper.addUser(user);
        session.commit();
        assertTrue(flag);
    }

    @Test
    public void testDeleteUserById() {
        boolean flag = mapper.deleteUserById(3);
        session.commit();
        assertTrue(flag);
    }

    @Test
    public void testGetUserById() {
        User u = mapper.getUserById(2);
        System.out.println(u);
    }

    @Test
    public void testUpdateUser() {
        User u = mapper.getUserById(2);
        u.setPassWord("admin");
        Boolean flag = mapper.updateUser(u);
        session.commit();
        assertTrue(flag);
    }

    @Test
    public void testQueryUserByPage() {
        List<User> users = mapper.queryUserByPage(0,2);
        for(User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void testQueryUserCnt() {
        Integer cnt = mapper.queryUserCnt();
        System.out.println(cnt);
    }

    @After
    public void after() {
        session.close();
    }
}
