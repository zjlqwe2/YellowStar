package util.impl;

import entity.House;
import util.RowMapperObject;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: 我的袜子都是洞
 * @date: 2019/1/26
 * @description: 房产信息对象映射
 */
public class HouseMapperImpl implements RowMapperObject {
    /**
     * @param rs
     * @return
     * @throws SQLException
     */
    @Override
    public Object rowMapperObject(ResultSet rs) throws SQLException {
        House house = new House();
        house.setHid(rs.getInt("hid"));
        house.setUsername(rs.getString("username"));
        house.setHouse_type(rs.getString("house_type"));
        house.setArea(rs.getInt("area"));
        house.setGmt_buy(rs.getString("gmt_buy"));
        house.setBuilding(rs.getString("building"));
        house.setUnit(rs.getString("unit"));
        house.setHouse_num(rs.getString("house_num"));
        house.setGmt_create(rs.getString("gmt_create"));
        house.setGmt_modified(rs.getString("gmt_modified"));
        return house;
    }
}
