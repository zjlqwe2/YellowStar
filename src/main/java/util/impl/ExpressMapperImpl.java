package util.impl;

import entity.Express;
import util.RowMapperObject;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ExpressMapperImpl implements RowMapperObject {

    @Override
    public Object rowMapperObject(ResultSet rs) throws SQLException {
        Express express = new Express();
        express.setEid(rs.getInt("eid"));
        express.setExpress_name(rs.getString("express_name"));
        express.setUsername(rs.getString("username"));
        express.setExpress_id(rs.getString("express_id"));
        express.setIsTake(rs.getInt("is_take"));
        express.setGmt_create(rs.getString("gmt_create"));
        return express;
    }
}