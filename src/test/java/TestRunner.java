import dao.TestUserDao;
import manage.TestUserManage;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


/**
 * @author: 我的袜子都是洞
 * @description:
 * @path: PropertyManagement-PACKAGE_NAME-TestRunner
 * @date: 2019-04-29 16:47
 */
public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestUserDao.class);
        System.out.println("UserDao测试结果:"+result.wasSuccessful());

        result = JUnitCore.runClasses(TestUserManage.class);
        System.out.println("UserManage测试结果:"+result.wasSuccessful());
    }
}
