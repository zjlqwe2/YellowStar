package manage.impl;

import entity.Device;
import exception.DeviceException;
import manage.DeviceManage;

import java.util.List;

/**
 * @author: 我的袜子都是洞
 * @description:
 * @path: PropertyManagement-manage.impl-DeviceManageImpl
 * @date: 2019-04-30 01:18
 */
public class DeviceManageImpl implements DeviceManage {
    /**
     * 根据did获取某设备信息
     *
     * @param did
     * @return
     * @throws DeviceException
     */
    @Override
    public Device getDevice(int did) throws DeviceException {
        return null;
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
        return false;
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
        return false;
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
        return false;
    }

    /**
     * 列出设备信息
     *
     * @return
     * @throws DeviceException
     */
    @Override
    public List<Device> listDevice() throws DeviceException {
        return null;
    }
}
