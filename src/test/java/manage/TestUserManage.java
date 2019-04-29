package manage;

import entity.User;
import exception.UserException;
import manage.impl.UserManageImpl;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * @author: 我的袜子都是洞
 * @description:
 * @path: PropertyManagement-manage-TestUserManage
 * @date: 2019-04-29 19:41
 */
public class TestUserManage {
    private UserManage userManage = new UserManageImpl();

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
    public void testLogin() {
        System.out.println("测试login(String loginname, String password)方法");
        try {
            User user = userManage.login("admin","admin");
            checkUserNotNull(user);
            user = userManage.login("admin","");
            assertNull(user);
            user = userManage.login("","");
            assertNull(user);
            user = userManage.login("admin1","admin");
            assertNull(user);
        } catch (UserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetUserByUid() {
        System.out.println("测试getUser(int uid)方法");
        try {
            User user = userManage.getUser(1);
            checkUserNotNull(user);
            user = userManage.getUser(-1);
            assertNull(user);
            user = userManage.getUser(10);
            assertNull(user);
        } catch (UserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSaveUser() {
        System.out.println("测试saveUser(String loginname, String password, int usertype)方法");
        try {
            boolean flag = userManage.saveUser("user2","password1",1);
            assertTrue(flag);
        } catch (UserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteUser() {
        System.out.println("测试deleteUser(int uid)方法");
        try {
            boolean flag = userManage.deleteUser(4);
            assertTrue(flag);
        } catch (UserException e) {
            e.printStackTrace();
        }
    }
}
