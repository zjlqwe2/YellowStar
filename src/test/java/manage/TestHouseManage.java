package manage;

import entity.House;
import exception.HouseException;
import manage.impl.HouseManageImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: 我的袜子都是洞
 * @description:
 * @path: PropertyManagement-manage-TestHouseManage
 * @date: 2019-04-30 13:50
 */
public class TestHouseManage {

    private HouseManage houseManage = new HouseManageImpl();

    @Test
    public void testSaveHouse() {
        System.out.println("测试saveHouse(House house)方法");
        House house = new House();
        house.setUserName("王麻");
        house.setIdentity("121131231");
        house.setPhone("13409102102");
        house.setHouseType("一室八厅");
        house.setGmtBuy("2019-01-01");
        house.setArea(30);
        house.setBuilding("8栋");
        house.setUnit("二单元");
        house.setHouseNum("909");
        house.setLocation("8车位");
        house.setLicenseplatenumber("苏C 12345");
        try {
            boolean flag = houseManage.saveHouse(house,"admin");
            assertTrue(flag);
        } catch (HouseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateHouse() {
        System.out.println("测试updateHouse(House house)方法");
        House house = new House();
        house.setHid(2);
        house.setUserName("张三");
        house.setIdentity("121131231");
        house.setPhone("2133");
        house.setHouseType("一室八厅");
        house.setGmtBuy("2019-01-01");
        house.setArea(30);
        house.setBuilding("8栋");
        house.setUnit("一单元");
        house.setHouseNum("909");
        house.setLocation("1车位");
        house.setLicenseplatenumber("苏A 88888");
        try {
            boolean flag = houseManage.updateHouse(house,"admin");
            assertTrue(flag);
        } catch (HouseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetHouse() {
        System.out.println("测试getHouse(int hid)方法");
        try {
            House house = houseManage.getHouse(1);
            assertEquals(1,house.getHid());
            house = houseManage.getHouse(-1);
            assertNull(house);
        } catch (HouseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListHouse() {
        System.out.println("测试listHouse()方法");
        try {
            List<House> list = houseManage.listHouse();
            assertTrue(list.size()>0);
        } catch (HouseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelHouse() {
        System.out.println("测试delHouse(int hid)方法");
        try {
            boolean flag = houseManage.delHouse(4,"admin");
            assertTrue(flag);
        } catch (HouseException e) {
            e.printStackTrace();
        }
    }

}
