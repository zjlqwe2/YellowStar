package util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: 我的袜子都是洞
 * @date: 2019/1/26
 * @description: 数据库记录映射对象
 */
public interface RowMapperObject {
    /**
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    Object rowMapperObject (ResultSet rs) throws SQLException;
}
