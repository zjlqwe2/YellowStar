package util.impl;

import entity.Cost;
import util.RowMapperObject;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CostMapperImpl implements RowMapperObject {

    @Override
    public Object rowMapperObject(ResultSet rs) throws SQLException {
        Cost cost = new Cost();
        cost.setId(rs.getInt("id"));
        cost.setHid(rs.getInt("hid"));
        cost.setCostType(rs.getInt("cost_type"));
        cost.setPrice(rs.getDouble("price"));
        cost.setGmtCreate(rs.getString("gmt_create"));
        return cost;
    }
}
