package dao;

import dao.impl.ExpressDaoImpl;
import entity.Express;
import org.junit.Test;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;


/**
 * @author: 我的袜子都是洞
 * @description:
 * @path: PropertyManagement-dao-TestExpressDao
 * @date: 2019-04-30 00:31
 */
public class TestExpressDao {

    private ExpressDao expressDao = new ExpressDaoImpl();

    @Test
    public void testSaveExpress(){
        System.out.println("测试saveExpress(Express express)方法");
        Express express = new Express();
        express.setExpress_name("中通快递");
        express.setUsername("李四");
        express.setPhone("13421231231");
        express.setExpress_id("1231231313");
        try {
            boolean flag = expressDao.saveExpress(express);
            assertTrue(flag);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateExpress() {
        System.out.println("测试updateExpress(Express express)方法");
        Express express = new Express();
        express.setEid(1);
        try {
            boolean flag = expressDao.updateExpress(express);
            assertTrue(flag);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListAllExpress() {
        System.out.println("测试listAllExpress()方法");
        try {
            List<Express> list = expressDao.listAllExpress();
            for (Express e:list) {
                System.out.println(e);
            }
            assertTrue(list.size()>0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNotTakeExpress() {
        System.out.println("测试listNotTakeExpress()方法");
        try {
            List<Express> list = expressDao.listNotTakeExpress();
            for (Express e:list) {
                System.out.println(e);
            }
            assertTrue(list.size()>0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
