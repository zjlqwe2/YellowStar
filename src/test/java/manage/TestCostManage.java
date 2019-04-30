package manage;

import entity.Cost;
import entity.House;
import exception.CostException;
import manage.impl.CostManageImpl;
import org.junit.Test;
import java.util.Map;
import static org.junit.Assert.*;

/**
 * @author: 我的袜子都是洞
 * @description:
 * @path: PropertyManagement-manage-TestCostManage
 * @date: 2019-04-30 12:56
 */
public class TestCostManage {
    private CostManage costManage = new CostManageImpl();

    @Test
    public void testSaveCost() {
        System.out.println("测试saveCost(Cost cost)方法");
        Cost cost = new Cost();
        cost.setCostType(1);
        cost.setHid(1);
        cost.setPrice(30);
        try {
            boolean flag = costManage.saveCost(cost);
            assertTrue(flag);
        } catch (CostException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateCost() {
        System.out.println("测试updateCost(Cost cost)方法");
        Cost cost = new Cost();
        cost.setId(1);
        cost.setCostType(1);
        cost.setHid(1);
        cost.setPrice(30);
        try {
            boolean flag = costManage.updateCost(cost);
            assertTrue(flag);
        } catch (CostException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListAllCost() {
        System.out.println("测试listAllCost(int costType)方法");
        try {
            Map<Cost, House> maps = costManage.listAllCost(1);
            assertTrue(maps.size()>0);
        } catch (CostException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteCost() {
        System.out.println("测试deleteCost(int id)方法");
        try {
            boolean flag = costManage.deleteCost(4);
            assertTrue(flag);
        } catch (CostException e) {
            e.printStackTrace();
        }
    }
}
