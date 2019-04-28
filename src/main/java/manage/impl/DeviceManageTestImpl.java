package manage.impl;

import entity.Device;
import exception.DeviceException;
import manage.DeviceManage;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 设备Manage层
 */
public class DeviceManageTestImpl implements DeviceManage {

    /**
     * 根据did获取某设备信息
     *
     * @param did
     * @return
     * @throws DeviceException
     */
    @Override
    public Device getDevice(int did) throws DeviceException {
        Device device = new Device();
        device.setDid(did);
        device.setUid(did+5);
        device.setDevice_name("消防栓"+did);
        device.setGmt_create("2019-0-01");
        device.setProcessing_opinion("admin");
        device.setIs_service(1);
        return device;
    }

    /**
     * 添加设备信息
     *
     * @param device
     * @return
     * @throws DeviceException
     */
    @Override
    public boolean saveDevice(Device device) throws DeviceException {
        System.out.println("添加设备");
        return true;
    }

    /**
     * 删除某设备信息
     *
     * @param did
     * @return
     * @throws DeviceException
     */
    @Override
    public boolean deleteDevice(int did) throws DeviceException {
        System.out.println("删除设备");
        return true;
    }

    /**
     * 修改某设备信息
     *
     * @param device
     * @return
     * @throws DeviceException
     */
    @Override
    public boolean updateDevice(Device device) throws DeviceException {
        System.out.println("更新设备");
        return true;
    }

    /**
     * 列出设备信息
     *
     * @return
     * @throws DeviceException
     */
    @Override
    public List<Device> listDevice() throws DeviceException {
        List<Device> list = new ArrayList<Device>();
        for (int i=1; i<20; i++) {
            Device device = new Device();
            device.setDid(i);
            device.setUid(i+5);
            device.setDevice_name("消防栓"+i);
            device.setGmt_create("2019-0-0-");
            device.setProcessing_opinion("admin");
            device.setIs_service(1);
            list.add(device);
        }
        return list;
    }

}
