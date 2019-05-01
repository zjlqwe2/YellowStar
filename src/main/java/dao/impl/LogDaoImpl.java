package dao.impl;

import dao.LogDao;
import entity.Log;
import util.DBHelp;
import util.impl.LogMapperImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 日志Dao
 */
public class LogDaoImpl implements LogDao {

    @Override
    public boolean saveLog(Log log) throws SQLException {
        int uid = log.getUid();
        String operation = log.getOperation();
        if (uid<1 || "".equals(operation)) {
            return false;
        }
        String sql = "INSERT INTO syslog (uid, operation) VALUES (?,?)";
        int i = DBHelp.executeUpdate(sql, uid, operation);
        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public List<Log> listLog() throws SQLException {
        String sql = "SELECT * FROM syslog";
        List<Object> list = DBHelp.executeQuery(sql, new LogMapperImpl());
        if (list==null || list.size()==0) {
            return null;
        }
        List<Log> logs = new ArrayList<Log>();
        for (Object o:list) {
            logs.add((Log)o);
        }
        return logs;
    }
}
