package util;

import java.sql.SQLException;

/**
 * @author: 我的袜子都是洞
 * @date: 2019/1/26
 * @description: 事务操作接口
 */
public interface Transaction {
    /**
     * 开启事务
     * @throws SQLException
     */
    void start () throws SQLException;

    /**
     * 回滚事务
     * @throws SQLException
     */
    void rollback () throws SQLException;

    /**
     * 关闭事务
     * @throws SQLException
     */
    void commit () throws SQLException;
}
