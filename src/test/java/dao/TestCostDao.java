package dao;

import dao.impl.CostDaoImpl;
import entity.Cost;
import org.junit.Test;
import java.sql.SQLException;
import java.util.List;
import static org.junit.Assert.assertTrue;

/**
 * @author: 我的袜子都是洞
 * @description:
 * @path: PropertyManagement-dao-TestCostDao
 * @date: 2019-04-30 01:01
 */
public class TestCostDao {
    private CostDao costDao = new CostDaoImpl();

    @Test
    public void testSaveCost() {
        System.out.println("测试saveCost(Cost cost)方法");
        Cost cost = new Cost();
        cost.setHid(1);
        cost.setCostType(2);
        cost.setPrice(100);
        try {
            boolean flag = costDao.saveCost(cost);
            assertTrue(flag);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListTypeCost() {
        System.out.println("测试listTypeCost(int hid, int costType)方法");
        try {
            List<Cost> list = costDao.listTypeCost(1,1);
            for (Cost e:list) {
                System.out.println(e);
            }
            assertTrue(list.size()>0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListAllCost() {
        System.out.println("测试listAllCost(int costType)方法");
        try {
            List<Cost> list = costDao.listAllCost(1);
            for (Cost e:list) {
                System.out.println(e);
            }
            assertTrue(list.size()>0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
