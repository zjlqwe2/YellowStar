package dao;

import dao.impl.LogDaoImpl;
import entity.Log;
import org.junit.Test;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: 我的袜子都是洞
 * @description:
 * @path: PropertyManagement-dao-TestLogDao
 * @date: 2019-05-01 11:47
 */
public class TestLogDao {

    private LogDao logDao = new LogDaoImpl();

    @Test
    public void testsaveLog() {
        System.out.println("测试saveLog(Log log)方法");
        Log log = new Log();
        log.setOperator("admin");
        log.setOperation("创建用户");
        try {
            boolean flag = logDao.saveLog(log);
            assertTrue(flag);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListLog() {
        System.out.println("测试listLog()方法");
        try {
            List<Log> list = logDao.listLog();
            assertTrue(list.size()>0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
