package util.impl;

import entity.UnitPrice;
import util.RowMapperObject;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: 我的袜子都是洞
 * @date: 2019/1/31
 * @description: 单价ORM映射
 */
public class UnitPriceMapperImpl implements RowMapperObject {
    /**
     * @param rs
     * @return
     * @throws SQLException
     */
    @Override
    public Object rowMapperObject(ResultSet rs) throws SQLException {
        UnitPrice unitPrice = new UnitPrice();
        unitPrice.setPid(rs.getInt("pid"));
        unitPrice.setCostType(rs.getInt("cost_type"));
        unitPrice.setUnitPrice(rs.getDouble("unit_price"));
        unitPrice.setGmt_create(rs.getString("gmt_create"));
        unitPrice.setGmt_modified(rs.getString("gmt_modified"));
        return unitPrice;
    }
}
