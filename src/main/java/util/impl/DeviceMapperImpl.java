package util.impl;

import entity.Device;
import util.RowMapperObject;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description: 设备信息对象映射
 */
public class DeviceMapperImpl  implements RowMapperObject {
    /**
     * @param rs
     * @return
     * @throws SQLException
     */
    @Override
    public Object rowMapperObject(ResultSet rs) throws SQLException {
        Device device = new Device();
        device.setDid(rs.getInt("did"));
        device.setDevice_name(rs.getString("device_name"));
        device.setDevice_type(rs.getString("device_type"));
        device.setIs_service(rs.getInt("is_service"));
        device.setProcessing_opinion(rs.getString("processing_opinion"));
        device.setHandlers(rs.getString("handlers"));
        device.setGmt_create(rs.getString("gmt_create"));
        return device;
    }
}
