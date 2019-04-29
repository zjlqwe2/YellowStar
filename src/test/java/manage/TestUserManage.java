package manage;

import entity.User;
import exception.UserException;
import manage.impl.UserManageImpl;
import org.junit.Test;
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
}
