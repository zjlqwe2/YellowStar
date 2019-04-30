package manage;

import entity.Express;
import exception.ExpressException;
import manage.impl.ExpressManageImpl;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

/**
 * @author: 我的袜子都是洞
 * @description:
 * @path: PropertyManagement-manage-TestExpressManage
 * @date: 2019-04-30 13:29
 */
public class TestExpressManage {
    private ExpressManage expressManage = new ExpressManageImpl();

    @Test
    public void testSaveExpress() {
        System.out.println("测试saveExpress(Express express)方法");
        Express express = new Express();
        express.setExpress_name("中通快递");
        express.setUsername("李四1");
        express.setPhone("24121231231");
        express.setExpress_id("1231231313");
        try {
            boolean flag = expressManage.saveExpress(express);
            assertTrue(flag);
        } catch (ExpressException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTakeExpress() {
        System.out.println("测试takeExpress(int id)方法");
        try {
            boolean flag = expressManage.takeExpress(2);
            assertTrue(flag);
        } catch (ExpressException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListAllExpress() {
        System.out.println("测试listAllExpress()方法");
        try {
            List<Express> list = expressManage.listAllExpress();
            assertTrue(list.size()>0);
        } catch (ExpressException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListNotTakeExpress() {
        System.out.println("测试listNotTakeExpress()方法");
        try {
            List<Express> list = expressManage.listNotTakeExpress();
            assertTrue(list.size()>0);
        } catch (ExpressException e) {
            e.printStackTrace();
        }
    }
}
