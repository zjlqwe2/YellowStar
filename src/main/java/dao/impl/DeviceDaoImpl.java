package dao.impl;

import dao.DeviceDao;
import entity.Device;
import util.DBHelp;
import util.impl.DeviceMapperImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: 我的袜子都是洞
 * @description:
 * @path: PropertyManagement-dao.impl-DeviceDaoImpl
 * @date: 2019-04-29 23:16
 */
public class DeviceDaoImpl implements DeviceDao {
    /**
     * 获取设备
     *
     * @param did
     * @return
     * @throws SQLException
     */
    @Override
    public Device getDevice(int did) throws SQLException {
        String sql = "SELECT * FROM device WHERE did = ?";
        List<Object> list = DBHelp.executeQuery(sql, new DeviceMapperImpl(), did);
        if (list==null || list.size()==0) {
            return null;
        }
        return (Device) list.get(0);
    }

    /**
     * 保存设备
     *
     * @param device
     * @return
     * @throws SQLException
     */
    @Override
    public boolean saveDevice(Device device) throws SQLException {
        String device_name = device.getDevice_name();
        String device_type = device.getDevice_type();
        int is_service = device.getIs_service();
        String processing_opinion = device.getProcessing_opinion();
        String user = device.getUser();
        if ("".equals(user) ||
            "".equals(device_name) ||
                "".equals(device_type) ||
                "".equals(processing_opinion)
        ) {
            return false;
        }
        String sql = "INSERT INTO device (device_name, device_type, is_service, processing_opinion, user) VALUES (?,?,?,?,?)";
        int i = DBHelp.executeUpdate(sql, device_name,device_type,is_service,processing_opinion,user);
        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 更新设备
     *
     * @param device
     * @return
     * @throws SQLException
     */
    @Override
    public boolean updateDevice(Device device) throws SQLException {
        int did = device.getDid();
        String device_name = device.getDevice_name();
        String device_type = device.getDevice_type();
        int is_service = device.getIs_service();
        String processing_opinion = device.getProcessing_opinion();
        String  user = device.getUser();
        if (did<1 || "".equals(user) ||
                "".equals(device_name) ||
                "".equals(device_type) ||
                "".equals(processing_opinion)
        ) {
            return false;
        }
        String sql = "UPDATE device SET device_name=?,device_type=?,is_service=?,processing_opinion=?,user=? WHERE did=?";
        int i = DBHelp.executeUpdate(sql, device_name,device_type,is_service,processing_opinion,user,did);
        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 删除设备
     *
     * @param did
     * @return
     * @throws SQLException
     */
    @Override
    public boolean deleteDevice(int did) throws SQLException {
        String sql = "DELETE FROM device WHERE did=?";
        int flag = DBHelp.executeUpdate(sql, did);
        if (flag == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 列出设备
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List listDevice() throws SQLException {
        String sql = "SELECT * FROM device";
        List<Object> list = DBHelp.executeQuery(sql, new DeviceMapperImpl());
        if (list==null || list.size()==0) {
            return null;
        }
        List<Device> devices = new ArrayList<Device>();
        for (Object item:list) {
            devices.add((Device) item);
        }
        return devices;
    }
}
