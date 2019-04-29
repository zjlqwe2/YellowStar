package dao;

import dao.impl.UserDaoImpl;
import entity.User;
import org.junit.Test;
import java.sql.SQLException;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author: 我的袜子都是洞
 * @description:
 * @path: PropertyManagement-dao-TestUserDao
 * @date: 2019-04-29 16:38
 */
public class TestUserDao {
    private UserDao userDao = new UserDaoImpl();
    private String loginname = "admin";
    private int uid = 1;

    /**
     * 检查User对象不为空
     * @param user
     */
    private void checkUserNotNull(User user) {
        assertNotNull(user.getUid());
        assertNotNull(user.getLoginName());
        assertNotNull(user.getUserType());
        assertNotNull(user.getPassWord());
    }

    @Test
    public void testGetUserById() {
        System.out.println("测试getUser(int id)方法");
        User user;
        try {
            user = userDao.getUser(uid);
            assertEquals(uid,user.getUid());
            checkUserNotNull(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetUserByLoginname() {
        System.out.println("测试getUser(String username)方法");
        User user;
        try {
            user = userDao.getUser(loginname);
            checkUserNotNull(user);
            user = userDao.getUser("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListAll() {
        System.out.println("测试listAll()方法");
        try {
            List<User> list = userDao.listAll();
            for (User u:list) {
                checkUserNotNull(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
