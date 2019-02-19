package util.impl;

import entity.Express;
import util.RowMapperObject;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: 我的袜子都是洞
 * @date: 2019/1/26
 * @description:
 */
public class ExpressMapperImpl implements RowMapperObject {
    /**
     * @param rs
     * @return
     * @throws SQLException
     */
    @Override
    public Object rowMapperObject(ResultSet rs) throws SQLException {
        Express express = new Express();
        express.setId(rs.getInt("id"));
        express.setUsername(rs.getString("username"));
        express.setPhone(rs.getString("phone"));
        express.setAddress(rs.getString("address"));
        express.setTake(rs.getInt("is_take"));
        express.setGmt_create(rs.getString("gmt_create"));
        express.setGmt_modified(rs.getString("gmt_modified"));
        return express;
    }
}
