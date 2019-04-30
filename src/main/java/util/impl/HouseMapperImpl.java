package util.impl;

import entity.House;
import util.RowMapperObject;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
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
        house.setUserName(rs.getString("user_name"));
        house.setIdentity(rs.getString("identity"));
        house.setPhone(rs.getString("phone"));
        house.setHouseType(rs.getString("house_type"));
        house.setArea(rs.getInt("area"));
        house.setGmtBuy(rs.getString("gmt_buy"));
        house.setBuilding(rs.getString("building"));
        house.setUnit(rs.getString("unit"));
        house.setHouseNum(rs.getString("house_num"));
        house.setLocation(rs.getString("location"));
        house.setBrand(rs.getString("brand"));
        house.setLicenseplatenumber(rs.getString("licenseplatenumber"));
        return house;
    }
}
