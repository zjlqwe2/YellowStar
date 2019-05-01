package manage;

import entity.Device;
import exception.DeviceException;
import java.util.List;

/**
 * 设备管理层
 */
public interface DeviceManage {

    /**
     * 根据did获取某设备信息
     * @param did
     * @return
     * @throws DeviceException
     */
    Device getDevice(int did) throws DeviceException;

    /**
     * 添加设备信息
     * @param device
     * @return
     * @throws DeviceException
     */
    public boolean saveDevice(Device device, String operator) throws DeviceException;

    /**
     * 删除某设备信息
     * @param did
     * @return
     * @throws DeviceException
     */
    public boolean deleteDevice(int did, String operator) throws DeviceException;

    /**
     * 修改某设备信息
     * @param device
     * @return
     * @throws DeviceException
     */
    public boolean updateDevice(Device device, String operator) throws DeviceException;

    /**
     * 列出设备信息
     * @return
     * @throws DeviceException
     */
    public List<Device> listDevice () throws DeviceException;
}
