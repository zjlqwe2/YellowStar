package dao;

import entity.Device;
import java.sql.SQLException;
import java.util.List;

public interface DeviceDao {

    /**
     * 获取设备
     * @param did
     * @return
     * @throws SQLException
     */
    Device getDevice(int did) throws SQLException;

    /**
     * 保存设备
     * @param device
     * @return
     * @throws SQLException
     */
    boolean saveDevice(Device device) throws SQLException;

    /**
     * 删除设备
     * @param did
     * @return
     * @throws SQLException
     */
    boolean deleteDevice(int did) throws SQLException;

    /**
     * 列出设备
     * @return
     * @throws SQLException
     */
    List listDevice() throws SQLException;


}
