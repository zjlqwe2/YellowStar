package manage.impl;

import dao.LogDao;
import dao.impl.LogDaoImpl;
import entity.Log;
import exception.LogException;
import manage.LogManage;
import java.sql.SQLException;
import java.util.List;

/**
 * @description: 日志Manage层
 */
public class LogManageImpl implements LogManage {

    private LogDao logDao = new LogDaoImpl();

    @Override
    public boolean saveLog(Log log) throws LogException {
        int uid = log.getUid();
        String operation = log.getOperation();
        if (uid<1 || "".equals(operation)) {
            return false;
        }
        try {
            boolean flag = logDao.saveLog(log);
            if (flag) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new LogException(e.getMessage());
        }
    }

    @Override
    public List<Log> listLog() throws LogException {
        try {
            List<Log> list = logDao.listLog();
            return list;
        } catch (SQLException e) {
            throw new LogException(e.getMessage());
        }
    }
}
