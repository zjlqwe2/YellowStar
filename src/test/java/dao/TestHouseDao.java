package dao;

import dao.impl.HouseDaoImpl;
import entity.House;
import org.junit.Test;
import java.sql.SQLException;
import static org.junit.Assert.*;

/**
 * @author: 我的袜子都是洞
 * @description:
 * @path: PropertyManagement-dao-TestHouseDao
 * @date: 2019-04-30 00:13
 */
public class TestHouseDao {

    private HouseDao houseDao = new HouseDaoImpl();

    @Test
    public void testGetHouseByHid() {
        System.out.println("测试getHouse(int hid)方法");
        House house;
        try {
            house = houseDao.getHouse(1);
            assertEquals(1,house.getHid());
            house = houseDao.getHouse(-1);
            assertNull(house);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSaveHouse() {
        System.out.println("测试saveHouse(House house)方法");
        House house = new House();
        house.setUserName("李四");
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
            boolean flag = houseDao.saveHouse(house);
            assertTrue(flag);
        } catch (SQLException e) {
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
            boolean flag = houseDao.updateHouse(house);
            assertTrue(flag);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelHouse() {
        System.out.println("测试delHouse(int hid)方法");
        try {
            boolean flag = houseDao.delHouse(2);
            assertTrue(flag);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
