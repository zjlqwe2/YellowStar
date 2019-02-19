package util.impl;

import entity.StallCost;
import util.RowMapperObject;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: 我的袜子都是洞
 * @date: 2019/2/6
 * @description:
 */
public class StallCostMapperImpl implements RowMapperObject {
    /**
     * @param rs
     * @return
     * @throws SQLException
     */
    @Override
    public Object rowMapperObject(ResultSet rs) throws SQLException {
        StallCost cost = new StallCost();
        cost.setId(rs.getInt("id"));
        cost.setHid(rs.getInt("hid"));
        cost.setUserName(rs.getString("username"));
        cost.setCostType(rs.getInt("cost_type"));
        cost.setUnitPrice(rs.getDouble("unit_price"));
        cost.setAmount(rs.getDouble("amount"));
        cost.setGmtCreate(rs.getString("gmt_create"));
        cost.setGmtModified(rs.getString("gmt_modified"));
        cost.setLocation(rs.getString("location"));
        cost.setLicenseplatenumber(rs.getString("licenseplatenumber"));
        return cost;
    }
}
