package util.impl;

import entity.Stall;
import util.RowMapperObject;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: 我的袜子都是洞
 * @date: 2019/1/26
 * @description: 车位信息映射
 */
public class StallMapperImpl implements RowMapperObject {
    /**
     * @param rs
     * @return
     * @throws SQLException
     */
    @Override
    public Object rowMapperObject(ResultSet rs) throws SQLException {
        Stall stall = new Stall();
        stall.setId(rs.getInt("id"));
        stall.setLocation(rs.getString("location"));
        stall.setLicenseplatenumber(rs.getString("licenseplatenumber"));
        stall.setGmt_create(rs.getString("gmt_create"));
        stall.setGmt_modified(rs.getString("gmt_modified"));
        stall.setId(rs.getInt("hid"));
        return stall;
    }
}
