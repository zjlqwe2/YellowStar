package util.impl;

import entity.Log;
import util.RowMapperObject;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description: 日志ORM
 */
public class LogMapperImpl implements RowMapperObject {
    /**
     * @param rs
     * @return
     * @throws SQLException
     */
    @Override
    public Object rowMapperObject(ResultSet rs) throws SQLException {
        Log log = new Log();
        log.setId(rs.getInt("id"));
        log.setOperator(rs.getString("operator"));
        log.setOperation(rs.getString("operation"));
        log.setGmt_create(rs.getString("gmt_create"));
        return log;
    }
}
