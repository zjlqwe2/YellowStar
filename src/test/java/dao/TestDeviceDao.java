package dao;

import dao.impl.DeviceDaoImpl;
import entity.Device;
import org.junit.Test;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: 我的袜子都是洞
 * @description:
 * @path: PropertyManagement-dao-TestDeviceDao
 * @date: 2019-04-30 00:49
 */
public class TestDeviceDao {
    private DeviceDao deviceDao = new DeviceDaoImpl();

    @Test
    public void testSaveDevice() {
        System.out.println("测试saveDevice(Device device)方法");
        Device device = new Device();
        device.setDevice_name("灭火器");
        device.setDevice_type("安全设施");
        device.setIs_service(1);
        device.setProcessing_opinion("干就对了");
        device.setUid(1);
        try {
            boolean flag = deviceDao.saveDevice(device);
            assertTrue(flag);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetDevice() {
        System.out.println("测试getDevice(int did)方法");
        Device device;
        try {
            device = deviceDao.getDevice(1);
            assertEquals(1,device.getDid());
            device = deviceDao.getDevice(-1);
            assertNull(device);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteDevice() {
        System.out.println("测试deleteDevice(int did)方法");
        try {
            boolean flag = deviceDao.deleteDevice(1);
            assertTrue(flag);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListDevice() {
        System.out.println("测试listDevice()方法");
        try {
            List<Device> list = deviceDao.listDevice();
            for (Device e:list) {
                System.out.println(e);
            }
            assertTrue(list.size()>0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
