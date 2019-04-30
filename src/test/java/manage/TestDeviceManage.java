package manage;

import entity.Device;
import exception.DeviceException;
import manage.impl.DeviceManageImpl;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

/**
 * @author: 我的袜子都是洞
 * @description:
 * @path: PropertyManagement-manage-TestDeviceManage
 * @date: 2019-04-30 13:36
 */
public class TestDeviceManage {

    private DeviceManage deviceManage = new DeviceManageImpl();

    @Test
    public void testSaveDevice() {
        System.out.println("测试saveDevice(Device device)方法");
        Device device = new Device();
        device.setDevice_name("警棍");
        device.setDevice_type("安全设施");
        device.setIs_service(1);
        device.setProcessing_opinion("干巴爹");
        device.setUid(1);
        try {
            boolean flag = deviceManage.saveDevice(device);
            assertTrue(flag);
        } catch (DeviceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateDevice() {
        System.out.println("测试updateDevice(Device device)方法");
        Device device = new Device();
        device.setDid(2);
        device.setDevice_name("警棍");
        device.setDevice_type("安全设施");
        device.setIs_service(1);
        device.setProcessing_opinion("干巴爹");
        device.setUid(1);
        try {
            boolean flag = deviceManage.updateDevice(device);
            assertTrue(flag);
        } catch (DeviceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetDevice() {
        System.out.println("测试getDevice(int did)方法");
        try {
            Device device = deviceManage.getDevice(2);
            assertNotNull(device.getDevice_name());
        } catch (DeviceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListDevice() {
        System.out.println("测试listDevice()方法");
        try {
            List<Device> list = deviceManage.listDevice();
            assertTrue(list.size()>0);
        } catch (DeviceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteDevice() {
        System.out.println("测试deleteDevice(int did)方法");
        try {
            boolean flag = deviceManage.deleteDevice(4);
            assertTrue(flag);
        } catch (DeviceException e) {
            e.printStackTrace();
        }
    }
}
