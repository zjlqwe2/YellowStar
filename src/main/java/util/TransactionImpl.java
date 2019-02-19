package util;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author: 我的袜子都是洞
 * @date: 2019/1/26
 * @description: 事务具体实现
 */
public class TransactionImpl implements Transaction {
    /**
     * 开启事务
     *
     * @throws SQLException
     */
    @Override
    public void start() throws SQLException {
        Connection conn = null;
        try {
            conn = DBHelp.getConnection();
            // 关闭自动提交事务
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     *
     * @throws SQLException
     */
    @Override
    public void rollback() throws SQLException {
        Connection conn = null;
        try {
            conn = DBHelp.getConnection();
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelp.close(null, null, conn);
        }
    }

    /**
     * 关闭事务
     *
     * @throws SQLException
     */
    @Override
    public void commit() throws SQLException {
        Connection conn = null;
        try {
            conn = DBHelp.getConnection();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelp.close(null, null, conn);
        }
    }
}
